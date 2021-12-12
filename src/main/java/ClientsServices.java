import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClientsServices {

        private static JSONArray actList = new JSONArray();
        private static ArrayList<Act> acts = new ArrayList<>();


        public static void  loadActsFromFile()  {

            Object p;
            JSONParser parser = new JSONParser();
            try{
                FileReader readFile = new FileReader("src/main/db/acts.json");
                BufferedReader read = new BufferedReader(readFile);
                p = parser.parse(read);
                if(p instanceof JSONArray)
                {
                    actList =(JSONArray)p;
                }

            } catch (ParseException | IOException ex) {
                ex.printStackTrace();
            }

        }

        public static void read () {

            JSONParser parser1 = new JSONParser();

            try (Reader reader = new FileReader("src/main/db/acts.json")) {
                JSONArray jsonArray = (JSONArray) parser1.parse(reader);

                Iterator<JSONObject> it = jsonArray.iterator();
                while (it.hasNext()) {
                    JSONObject obj = it.next();

                    Act act = new Act(obj.get("name").toString(),(List<String>) obj.get("map"),Integer.parseInt((String) obj.get("time")));
                    acts.add(act);

                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

        public static void  addAct(String name, List<String> map, int time)  {

            loadActsFromFile();
            read();


            //Punem un nou obiect in fisier
            JSONObject act = new JSONObject();

            act.put("name",name);
            act.put("time",time);
            act.put("map",map);
            actList.add(act);


            try (FileWriter file = new FileWriter("src/main/db/acts.json")) {

                file.write(actList.toString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

