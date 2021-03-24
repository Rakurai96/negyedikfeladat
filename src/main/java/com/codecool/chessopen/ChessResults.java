package com.codecool.chessopen;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChessResults {

    public List<String> getCompetitorsNamesFromFile(String fileName){
        if(fileName != null) {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(fileName).getFile());
            List<String> name = new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    String[] sp = line.split(",");
                    name.add(sp[0]);
                    int sum = 0;
                    sum += Integer.parseInt(sp[1]);
                    sum += Integer.parseInt(sp[2]);
                    sum += Integer.parseInt(sp[3]);
                    sum += Integer.parseInt(sp[4]);
                    sum += Integer.parseInt(sp[5]);
                    result.add(sum);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Sort(name, result);
        }
        return null;
    }
    private List<String> Sort(List<String> name, List<Integer> result) {
        for(int i = 0; i < result.size(); i++) {
            for(int j = i + 1; j < result.size(); j++) {
                if(result.get(i) < result.get(j)){
                    int swapRes = result.get(i);
                    result.set(i, result.get(j));
                    result.set(j, swapRes);
                    String swapName = name.get(i);
                    name.set(i, name.get(j));
                    name.set(j, swapName);
                }
            }
        }
        return name;
    }
}
