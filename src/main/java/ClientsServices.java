import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ClientsServices {

        private static JSONArray actList = new JSONArray();
        private static ArrayList<Act> acts = new ArrayList<>();


        public static void  loadActsFromFile()  {

            Object p;
            JSONParser parser = new JSONParser();
            try{
                FileReader readFile = new FileReader("C:\\Users\\madal\\IdeaProjects\\ggggg\\src\\main\\db\\acts.json");
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

        public static ArrayList<Act> read1 () {
            acts.clear();
            JSONParser parser1 = new JSONParser();

            try (FileReader reader = new FileReader("C:\\Users\\madal\\IdeaProjects\\ggggg\\src\\main\\db\\acts.json")) {
                JSONArray jsonArray = (JSONArray) parser1.parse(reader);

                Iterator<JSONObject> it = jsonArray.iterator();
                while (it.hasNext()) {
                    JSONObject obj = it.next();
                    String l1 = obj.get("map").toString();
                    List<String> l2=new ArrayList<>() ;
                    l2.add(l1);
                    int i1 = Integer.parseInt(obj.get("time").toString());
                    Act act23 = new Act(obj.get("name").toString(), l2,i1);
                    acts.add(act23);


                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return acts;
        }

        public static void  addAct(String name, List<String> map, int time)  {

            loadActsFromFile();
            read1();


            //Punem un nou obiect in fisier
            JSONObject act = new JSONObject();

            act.put("name",name);
            act.put("time",time);
            act.put("map",map);
            actList.add(act);


            try (FileWriter file = new FileWriter("C:\\Users\\madal\\IdeaProjects\\ggggg\\src\\main\\db\\acts.json")) {
                file.write(actList.toString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

