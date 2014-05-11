package lyk.practice.leetcode;
/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 5/9/14
 * Time: 9:29 PM
 * The WordLadder2 class is intended to fulfil some duties.
 */
import lyk.practice.Util;

import java.util.*;
import java.lang.*;
public class WordLadder2 {

        public static void main (String[] args) throws java.lang.Exception
        {
            HashSet<String> dict= new HashSet<String>();
            dict.addAll(Arrays.asList( new String [] {"hot","dot","dog","lot","log"}));
            test("hit","cog",dict);
            dict.clear();
            dict.addAll(Arrays.asList( new String [] {"cog","dot","dog","lot","log"}));
            test("hit","hot",dict);
            dict.clear();
            dict.addAll(Arrays.asList( new String [] {"dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams",
                    "boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele",
                    "suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"}));
           test("nape","mild",dict);
        }

        public static void test(String start, String end, HashSet<String> dict){
            ArrayList<ArrayList<String>> a = findLadders(start, end, dict);
            System.out.println(a);
        }
        public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
            ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();

            ArrayList<String> wordList= new ArrayList<String>( );
            wordList.add(start);
            wordList.addAll(dict);
            wordList.add(end);
            int s=wordList.size();

            int[][] diff = new int[s][s];

            for(int i =0; i <s;i++){
                for (int j =0 ; j<s;j++){
                    diff[i][j]= diff(wordList.get(i),wordList.get(j));
                }
            }

            int cur=0;
            HashSet<Integer> visited = new HashSet<Integer>();
            ArrayList<String> path = new ArrayList<String>();
            visited.add(Integer.valueOf(cur));
            path.add(wordList.get(cur));
            search(cur, s - 1, visited, path, diff, wordList, ret);

            int minl=Integer.MAX_VALUE;
            for(ArrayList<String> p:ret){
                minl = (p.size()<minl)? p.size():minl;
            }

            for (Iterator<ArrayList<String>> iter = ret.iterator(); iter.hasNext(); ) {
                ArrayList<String> obj = iter.next();
                if (obj.size()>minl) {
                    iter.remove();
                }
            }
            return ret;
        }
        public static void search(int cur, int s, HashSet<Integer> visited, ArrayList<String> path, int[][] diff, ArrayList<String> wordList, ArrayList<ArrayList<String>> ret){
            for(int i=0;i<=s;i++){
                if(!visited.contains(Integer.valueOf(i)) && diff[cur][i]==1){
                    visited.add(Integer.valueOf(i));
                    if(i!=s) {
                        path.add(wordList.get(i));
                        search(i, s, visited, path, diff, wordList, ret);
                        path.remove(wordList.get(i));
                    }else{
                        path.add(wordList.get(i));
                        //System.out.println(path);
                        ret.add((ArrayList<String>)path.clone());
                        path.remove(wordList.get(i));
                    }
                    visited.remove(Integer.valueOf(i));
                }
            }
        }
        public static int diff(String a, String b){
            int l = a.length();
            int diff=0;
            for(int i=0; i< l;i++){
                if(a.charAt(i)!=b.charAt(i)){
                    diff++;
                }
            }
            return diff;
        }

}
