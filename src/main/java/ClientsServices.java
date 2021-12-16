import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;

import static java.lang.Object.*;

public class ClientsServices {

        private static JSONArray actList = new JSONArray();
        private volatile static ArrayList<Act> acts = new ArrayList<>();


        public static void  loadActsFromFile()  {

            Object p;
            JSONParser parser = new JSONParser();
            try{
                FileReader readFile = new FileReader("D:\\ggggg\\src\\main\\db\\acts.json");
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

        public synchronized static ArrayList<Act> read1 () {
            acts.clear();
            JSONParser parser1 = new JSONParser();

            try (FileReader reader = new FileReader("D:\\ggggg\\src\\main\\db\\acts.json")) {
                JSONArray jsonArray = (JSONArray) parser1.parse(reader);

                Iterator<JSONObject> it = jsonArray.iterator();
                while (it.hasNext()) {
                    JSONObject obj = it.next();
                    List<String> l1 = (List<String>) obj.get("map");
                    int i1 = Integer.parseInt(obj.get("time").toString());
                    Act act23 = new Act(obj.get("name").toString(),l1 ,i1);
                    acts.add(act23);


                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return acts;
        }

        public  static void  addAct(String name, List<String> map, int time)  {

            loadActsFromFile();
            read1();


            //Punem un nou obiect in fisier
            JSONObject act = new JSONObject();

            act.put("name",name);
            act.put("time",time);
            act.put("map",map);
            actList.add(act);
            System.out.println("json " + actList);

            try (FileWriter file = new FileWriter("D:\\ggggg\\src\\main\\db\\acts.json")) {
                file.write(actList.toString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

