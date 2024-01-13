package DataSetAnalyzer;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Analyzer {
    public static ArrayList<String> readToArray(String filepath){
        ArrayList<String> wordList = new ArrayList<>();
        try {
            Scanner object = new Scanner(new File(filepath));
            while(object.hasNext()){
                wordList.add(object.next());
            }
            object.close();
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return wordList;
    }
    public static String predictor(String inputWord, String filePath){
        int existence = 0;
        ArrayList<String> out = readToArray(filePath);
        ArrayList<String> nextWord = new ArrayList<>();
        int length = out.size();

        for (int i=0; i<length-1; i++){
            if (inputWord.equals(out.get(i))){
                nextWord.add(out.get(i+1));
            }else{continue;}
        }
        int[] FrequencyHolder = new int[nextWord.size()];
        for (int i=0; i<nextWord.size(); i++){
            int frequency=0;
            for (int j=0; j<nextWord.size(); j++){
                if(i==j){
                    continue;
                }
                else if(nextWord.get(i)==nextWord.get(j)){
                    frequency += 1;
                }
            }
            FrequencyHolder[i] = frequency;
        }
        int prediction=0;
        for (int i=0; i<FrequencyHolder.length-1; i++){
            if(FrequencyHolder[i]<FrequencyHolder[i+1]){
                prediction= FrequencyHolder[i+1];
            }
        }
        System.out.println(prediction);
        return nextWord.get(prediction);
        }

    public static void main(String[] args){
        String filePath = "C:\\Users\\DELL\\Desktop\\PROGRAMMING\\JAVA\\WordPredictor\\test.txt";
        ArrayList<String> out = readToArray(filePath);
        String prediction = predictor("THE",filePath);
        System.out.println(prediction);
    }
}
