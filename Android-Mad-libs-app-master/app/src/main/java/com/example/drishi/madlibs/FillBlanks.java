package com.example.drishi.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import stanford.androidlib.SimpleActivity;

public class FillBlanks extends SimpleActivity {
    Random rand;
    int storyNum,indexOfType;//indexOftype can also be used to get the number of words remaining
    List<String> madWords;
    String[][] words={
            {"<job>", "<adjective>"},
            {"<adjective", "plural-noun", "noun", "adjective", "place", "plural-noun", "noun", "funny-noise", "adjective", "noun", "adjective", "plural-noun", "<person's-name>"},
            {"<adjective>", "<plural-noun>", "<plural-noun>", "<plural-noun>", "<adjective>", "<adjective>", "<plural-noun>", "<number>", "<noun>", "<plural-noun>", "<adjective>", "<job-title>", "<job-title>", "<noun>", "<plural-noun>", "<adjective>"},
            {"<Male-Name>", "<adjective>", "<CITY>", "<adjective>", "<unusual-adjective>", "<plural-noun>", "<plural-noun>", "<plural-noun>", "<plural-noun>", "<Color!>", "<adjective>", "<Exciting-adjective>", "<plural-noun>", "<Interesting-Adjective>"},
            {"<aDvErB>", "<NUMBER>", "<Plural-Noun>", "<verb>", "<body-part>", "<verb>", "<adverb>", "<pluRAL-nOUN>", "<plural-noun>", "<plural-noun>", "<FUNNY-noise>", "<verb>", "<Number>", "<verB>"}

    };
    String [] arr = {"I wannabe a <job> when I grow up.\n" +
            "Just like my dad.\n" +
            "Life is <adjective> like that!",

            "One of the most <adjective> characters in fiction is named\n" +
                    "\"Tarzan of the <plural-noun> .\" Tarzan was raised by a/an\n" +
                    "<noun> and lives in the <adjective> jungle in the\n" +
                    "heart of darkest <place> . He spends most of his time\n" +
                    "eating <plural-noun> and swinging from tree to <noun> .\n" +
                    "Whenever he gets angry, he beats on his chest and says,\n" +
                    "\" <funny-noise> !\" This is his war cry. Tarzan always dresses in\n" +
                    "<adjective> shorts made from the skin of a/an <noun>\n" +
                    "and his best friend is a/an <adjective> chimpanzee named\n" +
                    "Cheetah. He is supposed to be able to speak to elephants and\n" +
                    "<plural-noun> . In the movies, Tarzan is played by <person's-name> .",

            "Our American universities offer students many <adjective>\n" +
                    "courses that will prepare them to become professional <plural-noun> .\n" +
                    "You can get a degree as a Bachelor of <plural-noun> or take a\n" +
                    "regular liberal <plural-noun> course. Or, if you want to become\n" +
                    "a/an <adjective> engineer, you can study <adjective> mathematics\n" +
                    "and differential <plural-noun> . Then, after <number> years, if\n" +
                    "you want to continue your studies you can write a/an <noun> and\n" +
                    "become a Doctor of <plural-noun> . \n" +
                    "\n" +
                    "When you get out into the <adjective> world, if you have a diploma \n" +
                    "from a university, you will be able to get a job easily as a/an <job-title> \n" +
                    "or even a/an <job-title> . If you don't have a diploma, you may have to take\n" +
                    "a job as a <noun> . \n" +
                    "\n" +
                    "Remember, it's important that you study hard in high school so you are able \n" +
                    "to do well on your college entrance <plural-noun> . It is true that \"a little \n" +
                    "learning is a/an <adjective> thing.\"",

            "<Male-Name> has announced that his <adjective>\n" +
                    "clothing store in the heart of downtown <CITY> is having\n" +
                    "a/an <adjective> sale of all merchandise, including\n" +
                    "<unusual-adjective> suits and slightly irregular <plural-noun>\n" +
                    "available. Men's cable-knit <plural-noun> , only $15.99.\n" +
                    "Hand-woven Italian <plural-noun> , 1/2-price. Double-\n" +
                    "breasted cashmere <plural-noun> , $50.00. Genuine imported\n" +
                    "<Color!> <adjective> shoes, <Exciting-adjective> handerchiefs,\n" +
                    "and women's embroidered <plural-noun> , all at rock-bottom prices.\n" +
                    "This is a chance to get some really <Interesting-Adjective> bargains.",

            "Here's how you dance the Monstrosity. Stand with your feet together.\n" +
                    "Now, move your left foot <aDvErB> to the side. Now stamp your\n" +
                    "right foot <NUMBER> times and put your hands on your partner's\n" +
                    "<Plural-Noun> . Next, you both <verb> slowly to the right and bend\n" +
                    "your <body-part> backward. For the next eight counts,\n" +
                    "both of you <verb> <adverb> to the left. Next, you and\n" +
                    "your partner stand back to back and wiggle your <pluRAL-nOUN> and\n" +
                    "slap your <plural-noun> together. Don't forget to keep stamping\n" +
                    "your right foot. Now, face your partner again, put your <plural-noun>\n" +
                    "together and shout, \" <FUNNY-noise> !\" Now, <verb> backward\n" +
                    "and repeat the whole thing <Number> times. If you feel that you can't\n" +
                    "learn this dance, you can always <verB> the next one out."

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_blanks);
        Log.d("test1",arr[0]);
        rand=new Random();
        madWords=new ArrayList<>();
        pickRandomNumber();
        displayInfo();
    }

    private void pickRandomNumber(){
         storyNum=rand.nextInt(arr.length);
        // storyNum=0;
        madWords.clear();
        indexOfType = 0;
    }
    private void displayInfo(){
        TextView tv1=find(R.id.wordDetail);
        TextView tv2=find(R.id.numWordsLeft);
        tv2.setText(Integer.toString(words[storyNum].length - indexOfType-1) + " mads words left");
        tv1.setText("Enter a "+words[storyNum][indexOfType]);

    }
    private String getRes(){
        StringBuilder res=new StringBuilder();
        int i,j,n=arr[storyNum].length(),k=0;
        char [] arr2=arr[storyNum].toCharArray();
        i=0;
        while(i<n){
            j=i;
            while(j<n && arr2[j]!='<') j++;
            String sub= arr[storyNum].substring(i,j);
            res.append(sub);
            while(j<n && arr2[j]!='>') j++;
            j++;
            i=j;

            if(k<madWords.size()) {
                Log.d("res","madWords.get("+k+") is "+madWords.get(k));
                res.append(madWords.get(k));
                k++;
            }
            Log.d("res","res sofar is "+res.toString()+" i,n are "+i+","+n);
        }
        return res.toString();
    }
    public void nextWord(View view) {
        indexOfType++;
        EditText et=find(R.id.madWord);
        String word=et.getText().toString();
        et.setText("");
        Log.d("adding","adding word"+word);
        madWords.add(word);
        Log.d("index","indexOfType is "+indexOfType+" and words["+storyNum+"].length = "+words[storyNum].length);
        if(indexOfType==words[storyNum].length){
            Log.d("res","getting the result");
            String res=getRes();
            Log.d("res","\nfinal result is \n"+res);
            Intent intent=new Intent(this,MadStoryActivity.class);
            intent.putExtra("res",res);
            startActivity(intent);

        }else{
            displayInfo();
        }
    }
}
