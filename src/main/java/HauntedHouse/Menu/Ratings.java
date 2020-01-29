package HauntedHouse.Menu;

import Structures.Lists.OrderedList;
import Structures.Lists.OrderedListADT;

import java.io.*;
import java.util.Iterator;

/**
 *
 */
public class Ratings {

    /**
     *
     */
    private OrderedListADT<Result> resultList = new OrderedList();

    /**
     *
     * @param mapTitle
     * @param difficulty
     * @throws IOException
     */
    public void writeToRatingsFile(String mapTitle, int difficulty) throws IOException {

        String filename = "";

        String difficultyID = "";

        if(difficulty == 1){
            filename = mapTitle + "Easy.txt";
            difficultyID = "Easy";
        } else if(difficulty == 2){
            filename = mapTitle + "Medium.txt";
            difficultyID = "Medium";
        } else if(difficulty == 3){
            filename = mapTitle + "Hard.txt";
            difficultyID = "Hard";
        }

        // Create new file
        String path="ratings/" + filename;
        File file = new File(path);

        // If file doesn't exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        Iterator<Result> resultListItr = resultList.iterator();

        // Write in file
        bw.write(mapTitle);
        bw.write(" - ");
        bw.write(difficultyID);
        bw.newLine();

        while(resultListItr.hasNext()){

            Result tmpRes = resultListItr.next();

            bw.append(tmpRes.playerName + " -   Points :"
                    + tmpRes.playerPoints);
            bw.newLine();
        }

        // Close connection
        bw.close();
    }

    /**
     *
     */
    public void PrintRatingFile(String mapTitle, int difficulty) throws IOException {

        String filename = mapTitle;

        if(difficulty == 1){
            filename += "Easy.txt";
        } else if(difficulty == 2){
            filename += "Medium.txt";
        } else  if(difficulty == 3){
            filename += "Hard.txt";
        }

        BufferedReader br = new BufferedReader(new FileReader(filename));
        for (String line; (line = br.readLine()) != null;) {
            System.out.println(line);

        }

        br.close();
    }

    /**
     *
     * @return
     */
    public OrderedListADT<Result> getResultList() {
        return resultList;
    }
}
