package ru.project.system.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LinearSearchApplication {

    public static void main(String[] args) {
        List<String> wordsList = new ArrayList<>();
        String searchWord = null;

        for (int i = 0; i < 1000000; i++){
            wordsList.add("слово" + i + "бишбахххххххххххх");
            System.out.println(i);
        }

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите слова одной строкой, разделенных пробелами");
            wordsList.add(bufferedReader.readLine());
            //wordsList = new ArrayList<>(Arrays.asList(bufferedReader.readLine().split(" ")));

            System.out.println("Введите слово для поиска");
            searchWord = bufferedReader.readLine().trim();
        } catch (Exception e) {
            e.printStackTrace();
        }

        LocalDateTime endDate = null;
        LocalDateTime startDate = LocalDateTime.now();
        Integer position = null;

        List<String> sortedWords = wordsList.stream()
                .sorted()
                .collect(Collectors.toList());

        for (int i = 0; i < sortedWords.size(); i++) {
            if (sortedWords.get(i).equals(searchWord)) {
                endDate = LocalDateTime.now();
                position = i;
                break;
            }
        }

        if (endDate == null) {
            System.out.println("Совпадений не найдено, слова " + searchWord + " нет в списке");
            return;
        }
        System.out.println("Слово " + searchWord + " есть, его номер: " + position);
        System.out.println(endDate.getNano()/1000000 - startDate.getNano()/1000000 +
                " наносекунд занял процесс сортировки и поиск слова " + searchWord);
    }
}
