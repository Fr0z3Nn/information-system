package ru.project.system.generator;

import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.Map;

public class Controller {
    @FXML
    public BarChart<String, Number> rateGraph;
    @FXML
    public Button genButton;
    private static int count = 1;
    @FXML
    public AreaChart<String, Number> diffFunc;
    @FXML
    public Text mathozh;
    @FXML
    public Text dispers;
    @FXML
    public Text pi;
    @FXML
    public TextField NValue;

    @FXML
    public void initialize() {
        rateGraph.getXAxis().setLabel("Число");
        rateGraph.getYAxis().setLabel("Частота появления");
        rateGraph.setBarGap(0);
        rateGraph.setCategoryGap(1.0);
        rateGraph.setTitle("Частота появления значений случайной величины");
        diffFunc.getYAxis().setLabel("Плотность вероятности");
        diffFunc.getXAxis().setLabel("Число");
        diffFunc.setTitle("Интегральная функция распределения");
        genButton.setOnMouseClicked(event -> {
            setAllData();
        });
    }

    private void setAllData() {
        double numVarioty;
        System.out.println(NValue.getText());
        if (NValue.getText().equals("")) {
            numVarioty = 10000;
        } else {
            numVarioty = Double.parseDouble(NValue.getText());
        }
        Map<Integer, Integer> genNewRes = Generator.genMeth((int) numVarioty);
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName(String.valueOf(++count));
        double verNew = 0;
        XYChart.Series<String, Number> diffSeriesNew = new XYChart.Series<>();
        for (int i = 0; i < 100; i++) {
            int numGET;
            try {
                numGET = genNewRes.get(i);
            } catch (Exception e) {
                numGET = 0;
            }
            series.getData().add(new XYChart.Data<>(String.valueOf(i), numGET));
            diffSeriesNew.getData().add(new XYChart.Data<>(String.valueOf(i), verNew += numGET / numVarioty));
        }
        // Add Series to BarChart.
        rateGraph.getData().add(series);
        diffFunc.getData().add(diffSeriesNew);

        double mathOzhNewGen = 0;
        for (int i = 0; i < 100; i++) {
            int numGET;
            try {
                numGET = genNewRes.get(i);
            } catch (Exception e) {
                numGET = 0;
            }
            mathOzhNewGen += i * numGET / numVarioty;
        }
        mathozh.setText(String.format("Мат. ожидание: %.4f", mathOzhNewGen));

        double desp = 0;
        for (int i = 0; i < 100; i++) {
            int numGET;
            try {
                numGET = genNewRes.get(i);
            } catch (Exception e) {
                numGET = 0;
            }
            desp += Math.pow((i - mathOzhNewGen), 2) * (numGET / numVarioty);
        }
        dispers.setText(String.format("Дисперсия: %.4f", desp));
        pi.setText("Число PI: " + Generator.pi((int)numVarioty));
    }
}
