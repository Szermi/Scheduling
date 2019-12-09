package com.company;


import java.io.IOException;
import java.util.List;

public class Main {

    public static int TASKSNUMBER = 50;
    private static long startMeasure;
    private static long endMeasure;
    private static int delay;

    public static void main(String[] args) throws IOException {

        //InstancesCreator creator = new InstancesCreator();
        //creator.create();


        FilesList filesList = new FilesList();
        List<String> files = filesList.run();


        DataLoader loader = new DataLoader();
        for(String file: files)
        {
            System.out.println(file);

            //List<Task> parameters = loader.load(TASKSNUMBER, "data/in132349_" + TASKSNUMBER + ".txt");
            List<Task> parameters = loader.load(TASKSNUMBER, file);

            DelayCounter delayCounter = new DelayCounter();

            //LIST ALGORITHM
            NaiveAlgorithm naiveAlgorithm = new NaiveAlgorithm();
            startMeasure = System.nanoTime();
            List<List<Task>> listAlgorithmResult = naiveAlgorithm.run(parameters);
            endMeasure = System.nanoTime();
            delay = delayCounter.run(listAlgorithmResult);
            System.out.println("(" + (endMeasure-startMeasure)/1000 + "ms) RESULT FOR LIST: " + delay);

            //SORT ALGORITHM
//            SortAlgorithm sortAlgorithm = new SortAlgorithm();
//            startMeasure = System.nanoTime();
//            List<List<Task>> sortAlgorithmResult = sortAlgorithm.run(parameters);
//            endMeasure = System.nanoTime();
//            delay = delayCounter.run(sortAlgorithmResult);
//            System.out.println("(" + (endMeasure-startMeasure)/1000 + "ms) RESULT FOR SORT: " + delay);



//            DataSaver dataSaver = new DataSaver();
//            dataSaver.save("results/" + file, sortAlgorithmResult, delay);
        }
    }
}