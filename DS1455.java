class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
       String [] word = sentence.split(" ");
       for(int i=0;i<word.length;i++){
        if(word[i].startsWith(searchWord)){
            return i+1;
        }
       }
       return -1;
       }
}
//2185
class Solution {
    public int prefixCount(String[] words, String pref) {
        int count =0;
        for(int i=0;i<words.length;i++){
            if(words[i].startsWith(pref)){
                count++;
            }
        }
        return count;        
    }
}
//1961
class Solution {
    public boolean isPrefixString(String s, String[] words) {
       String str ="";
       for(int i=0;i<words.length;i++){
        if(s.indexOf(words[i])== -1){
            return false;
        }
        str += words[i];
        if(s.equals(str)){
            return true;
        }
       }
       return false;
    }
}
