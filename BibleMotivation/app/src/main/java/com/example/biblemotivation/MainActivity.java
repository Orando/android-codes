package com.example.biblemotivation;



import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;
import com.chalo.biblemotivation.R;

public class MainActivity extends Activity 
{
	float x1,x2;
    float y1, y2;
    int randomnumber;
    TextView tvmessage;
    int randno;
    String[] proverbs = {"Then said Jesus, 'Father, forgive them; for they know not what they do.' - Luke 23:34",
"Judge not, and ye shall not be judged; condemn not, and ye shall not be condemned; forgive, and ye shall be forgiven. - Luke 6:37",
"And Jesus said unto them... 'If ye have faith as a grain of mustard seed, ye shall say unto this mountain, remove hence to yonder place; and it shall remove; and nothing shall be impossible to you.' - Matthew 17:20",
"It is God who arms me with strength and makes my way perfect... He enables me to stand on the heights. He trains my hands for battle; my arms can bend a bow of bronze. You give me your shield of victory, and your right hand sustains me.  Psalm 18:32-35",
"So do not fear, for I am with you; do not be dismayed, for I am your God. I will strengthen you and help you; I will uphold you with my righteous right hand. - Isaiah 41:10",
"When times are good, be happy; but when times are bad, consider; God has made the one as well as the other. - Ecclesiastes 7:14",
"Be strong and courageous. Do not be afraid or terrified because of them, for the Lord your God goes with you; he will never leave you nor forsake you. - Deuteronomy 31:6",
"There is neither Jew nor Greek, there is neither bond nor free, there is neither male nor female: for ye are all one in Christ. - Galatians 3:28",
"I can do everything through him who gives me strength. - Philippians 4:13",
"But the fruit of the Spirit is love, joy, peace, patience, kindness, goodness, faithfulness, gentleness, self control. Against such there is no law. And those who are Christ's have crucified the flesh with its passions and desires. Galatians 5:22-25",
"'For I know the plans I have for you', declares the Lord, 'plans to prosper you and not to harm you, plans to give you hope and a future.' - Jeremiah 29:11",
"Lord, you have assigned me my portion and my cup; you have made my lot secure. The boundary lines have fallen for me in pleasant places; surely I have a delightful inheritance... I have set the Lord always before me. Because he is at my right hand, I will not be shaken. - Psalm 16:5-8",
"Do not let your hearts be troubled. Trust in God; trust also in me. In my Father's house are many rooms... I am going there to prepare a place for you... I will come back and take you to be with me that you also may be where I am. - John 14:1-3",
"Commit to the Lord whatever you do, and your plans will succeed. - Proverbs 16:3",
"Beloved, let us love one another, for love is from God, and whoever loves has been born of God and knows God. Anyone who does not love does not know God, because God is love. - 1 John 4:7-8",
"May the God of hope fill you all with joy and peace in believing, so that by the power of the Holy Spirit you may abound in hope. - Romans 15:13",
"The Lord is my light and my salvation - whom shall I fear? The Lord is the stronghold of my life - of whom shall I be afraid? - Psalm 27:1",
"And be ye kind one to another, tender-hearted, forgiving one another, even as God for Christ's sake hath forgiven you. - Ephesians 4:32",
"My flesh and my heart may fail, but God is the strength of my heart and my portion forever. - Psalm 73:26",
"Even though I walk through the valley of the shadow of death, I will fear no evil, for you are with me; your rod and your staff, they comfort me. - Psalm 23:4",
"The Lord is my shepherd; I shall not want. He maketh me to lie down in green pastures: he leadeth me beside the still waters. He restoreth my soul: he leadeth me in the paths of righteousness for his name's sake. - Psalm 23",
"So we do not lose heart. Though our outer self is wasting away, our inner self is being renewed day by day. - Corinthians 4:16-17",
"May God be gracious to us and bless us and make his face shine upon us. - Psalm 67:1",
"If you have faith as a grain of mustard seed, you will say to your mountain, 'MOVE!' and it WILL move... and NOTHING will be impossible for YOU! - Matthew 17:20",
"In the Lord, put your trust. - Psalms 11:1",
"The Lord will guide you always, he will satisfy your needs in a sun-scorched land. You will be like a spring whose waters never fail. - Isaiah 58:11",
"If you can believe, all things are possible to him who believeth. - Mark 9:23",
"Thou shall decree a thing and it shall be established unto thee and a light shall shine upon thy ways. - Job 22:28",
"Wait on the Lord, be of good courage, and he shall strengthen thine heart. Wait, I say on the Lord. - Psalms 27:14",
"Trust in the Lord with all your heart, and lean not on your own understanding. In all your ways acknowledge Him and He shall direct your paths. - Proverbs 3:5,6",
"Behold I am with thee, and will keep thee in all places whither thou goest. - Genesis 28:15",
"And I am sure that he who began a good work in you will complete it. - Philippians 1:6",
"With God all things are possible. - Matthew 19:26",
"Fear thou not . . . I will strengthen thee. . . I will help thee. - Isaiah 41:10",
"Your Father knoweth what things you have need of before you ask Him. - Matthew 6:8",
"Come unto me, ye who are weary and overburdened, and I will give you rest. - Matthew 11:28",
"Heaven and earth shall pass away: but my words shall not pass away. - Mark 13:31",
"Every word of God is pure: he is a shield unto them that put their trust in him. - Proverbs 30:5",
"And this is the confidence that we have in Him, that, if we ask anything according to His will, He heareth us - 1 John 5:14-15",
"For God hath not given us a spirit of fear; but of power, and of love, and of a sound mind. - 2 Timothy 1:7",
"I can do all things through Christ which strengtheneth me. - Philippians 4:13",
"[Seek him] that maketh the seven stars and Orion, and turneth the shadow of death into the morning, and maketh the day dark with night... The LORD [is] his name. - Amos 5:7",
"The steps of a man are established by the LORD; And He delights in his way. When he falls, he shall not be hurled headlong; Because the LORD is the One who holds his hand. - Psalm 37:23-24",
"Let your character be free from the love of money, being content with what you have; for He Himself has said, 'I will never desert you, nor will I ever forsake you. - Hebrews 13:5", 
"I can do all things through Him who strengthens me. - Philippians 4:13",
"Yet those who wait for the LORD Will gain new strength; They will mount up with wings like eagles, They will run and not get tired, They will walk and not become weary. - Isaiah 40:31",
"I will instruct thee and teach thee in the way which thou shalt go: I will guide thee with mine eye. - Psalm 32:8",
"Trust in the LORD, and do good... Delight thyself also in the LORD: and he shall give thee the desires of thine heart. Commit thy way unto the LORD; trust also in him; and he shall bring it to pass. - Psalm 37:3-5",
"Do not be anxious about anything, but in everything, by prayer and petition, with thanksgiving, present your requests to God. - Philippians 4:6",
"No discipline seems pleasant at the time, but painful. Later on, however, it produces a harvest of righteousness and peace for those who have been trained by it. - Hebrews 12:11-13",
"Cast your burden on the LORD, And He shall sustain you; He shall never permit the righteous to be moved. - Psalm 55:22",
"But certainly God has heard me; He has attended to the voice of my prayer. Blessed be God, Who has not turned away my prayer, Nor His mercy from me! - Psalm 66:19-20",
"Don't let anyone look down on you because you are young, but set an example for the believers in speech, in life, in love, in faith and in purity. - 1 Timothy 4:12",
"'For I know the plans I have for you,' declares the LORD, 'plans to prosper you and not to harm you, plans to give you hope and a future. - Jeremiah 29:11",
"Listen, my son, to your father's instruction and do not forsake your mother's teaching. They will be a garland to grace your head and a chain to adorn your neck. - Proverbs 1:8-9",
"Do not let your hearts be troubled. Trust in God; trust also in me. - John 14:1",
"For God so loved the world that he gave his one and only Son, that whoever believes in him shall not perish but have eternal life. - John 3:16",
"Humble yourselves, therefore, under God's mighty hand, that he may lift you up in due time. Cast all your anxiety on him because he cares for you. Be self-controlled and alert.  - 1 Peter 5:5-9",
"Remember your Creator in the days of your youth, before the days of trouble come and the years approach when you will say, 'I find no pleasure in them.' - Ecclesiastes 12:1",
"My soul, wait silently for God alone, For my expectation is from Him. He only is my rock and my salvation; He is my defense; I shall not be moved... The rock of my strength, And my refuge, is in God. Psalm 62:5-8",
"And he said, 'The LORD is my rock and my fortress and my deliverer; My God, my rock, in whom I take refuge; My shield and the horn of my salvation, my stronghold and my refuge; My savior, Thou dost save me from violence. 2 Samuel 22:2-4",
"These things I have spoken to you, that in Me you may have peace. In the world you have tribulation, but take courage; I have overcome the world. - John 16:33",
"How blessed is he who considers the helpless; The LORD will deliver him in a day of trouble. The LORD will protect him, and keep him alive, And he shall be called blessed upon the earth- Psalm 41:1-3",
"Therefore, take up the full armor of God, that you may be able to resist in the evil day, and having done everything, to stand firm. - Ephesians 6:13",
"Though I walk in the midst of trouble, Thou wilt revive me; Thou wilt stretch forth Thy hand against the wrath of my enemies, And Thy right hand will save me. - Psalm 138:7",
"Trust in the LORD with all your heart, And do not lean on your own understanding. In all your ways acknowledge Him, And He will make your paths straight - Proverbs 3:5-6",
"I will not be afraid of ten thousands of the people That have set themselves against me round about. - Psalm 3:6",
"The LORD also will be a stronghold for the oppressed, A stronghold in times of trouble. - Psalm 9:9",
"The LORD is the one who goes ahead of you; He will be with you. He will not fail you or forsake you. Do not fear or be dismayed. - Deuteronomy 31:8",
"And the light shines in the darkness, and the darkness did not comprehend it. - John 1:5"
 };
   @Override
protected void onCreate(Bundle savedInstanceState) 
   {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	tvmessage=(TextView) findViewById(R.id.tvresults);
	
	
	 Typeface typeFace=Typeface.createFromAsset(getAssets(),"font/2218167120.ttf");
	 tvmessage.setTypeface(typeFace);
	
}
    // onTouchEvent () method gets called when User performs any touch event on screen 
   // Method to handle touch event like left to right swap and right to left swap
                public boolean onTouchEvent(MotionEvent touchevent) 
                {
                             switch (touchevent.getAction())
                             {
                                    // when user first touches the screen we get x and y coordinate
                                     case MotionEvent.ACTION_DOWN: 
                                     {
                                         x1 = touchevent.getX();
                                         y1 = touchevent.getY();
                                         break;
                                    }
                                     case MotionEvent.ACTION_UP: 
                                     {
                                         x2 = touchevent.getX();
                                         y2 = touchevent.getY(); 

                                         //if left to right sweep event on screen
                                         if (x1 < x2) 
                                         {
                                        	 Random rnd = new Random();
                                        	 int randno = rnd.nextInt(proverbs.length);
                                        	
                                        tvmessage.setText(proverbs[randno]);
                                        	 
                                             Toast.makeText(this, "Swap: Left to Right", Toast.LENGTH_SHORT).show();
                                          }
                                        
                                         // if right to left sweep event on screen
                                         if (x1 > x2)
                                         {
                                        	 Random rnd = new Random();
                                        	 int randno = rnd.nextInt(proverbs.length);
                                        	
                                        	 tvmessage.setText(proverbs[randno]);
                                             Toast.makeText(this, "Swap: Right to Left", Toast.LENGTH_SHORT).show();
                                         }
                                        
//                                         // if UP to Down sweep event on screen
//                                         if (y1 < y2) 
//                                         {
//                                             Toast.makeText(this, "UP to Down Swap Performed", Toast.LENGTH_LONG).show();
//                                         }
//                                        
//                                         //if Down to UP sweep event on screen
//                                         if (y1 > y2)
//                                         {
//                                             Toast.makeText(this, "Down to UP Swap Performed", Toast.LENGTH_LONG).show();
//                                          }
                                         break;
                                     }
                             }
                             return false;
                }

                
 @Override
 public boolean onCreateOptionsMenu(Menu menu)
 {
       // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
 }

	/*public boolean onOptionsItemSelected(MenuItem item) 
	{
		// TODO Auto-generated method stub
		switch (item.getItemId())
		{
	case R.id.share:
     
		Intent sendIntent = new Intent(Intent.ACTION_SEND);
		//sendIntent.setAction(Intent.ACTION_SEND);
		sendIntent.putExtra(Intent.EXTRA_TEXT,"Message");
		sendIntent.setType("text/plain");
		startActivity(sendIntent);
     return true;
 
   
   
 default:
     
		return super.onOptionsItemSelected(item);
	}
	}*/
 

}
