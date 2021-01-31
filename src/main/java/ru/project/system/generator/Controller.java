package ru.project.system.generator;

import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
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
    public void initialize() {

        rateGraph.getXAxis().setLabel("Число");
        rateGraph.getYAxis().setLabel("Частота появления");
        rateGraph.setBarGap(0);
        rateGraph.setCategoryGap(1.0);
        rateGraph.setTitle("Частота появления значений случайной величины");
        diffFunc.getYAxis().setLabel("Плотность вероятности");
        diffFunc.getXAxis().setLabel("Число");
        diffFunc.setTitle("Интегральная функция распределения");
        setAllData();
        pi.setText("Число PI: " + Generator.pi());
        genButton.setOnMouseClicked(event -> {
            setAllData();
        });
    }

    private void setAllData() {
        Map<Integer, Integer> genNewRes = Generator.genMeth();
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName(String.valueOf(++count));
        double verNew = 0;
        XYChart.Series<String, Number> diffSeriesNew = new XYChart.Series<>();
        for (int i = 0; i < 100; i++) {
            series.getData().add(new XYChart.Data<>(String.valueOf(i), genNewRes.get(i)));
            diffSeriesNew.getData().add(new XYChart.Data<>(String.valueOf(i), verNew += genNewRes.get(i) / 10000.));
        }
        // Add Series to BarChart.
        rateGraph.getData().add(series);
        diffFunc.getData().add(diffSeriesNew);

        double mathOzhNewGen = 0;
        for (int i = 0; i < 100; i++) {
            mathOzhNewGen += i * genNewRes.get(i) / 10000.;
        }
        mathozh.setText(String.format("Мат. ожидание: %.4f", mathOzhNewGen));

        double desp = 0;
        for (int i = 0; i < 100; i++) {
            desp += Math.pow((i - mathOzhNewGen), 2) * (genNewRes.get(i) / 10000.);
        }
        dispers.setText(String.format("Дисперсия: %.4f", desp));

    }
}
