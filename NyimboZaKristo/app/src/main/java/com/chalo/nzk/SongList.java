package com.chalo.nzk;

import android.annotation.TargetApi;
import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toolbar;

import java.util.HashMap;


public class SongList extends ListActivity implements SearchView.OnQueryTextListener {
	ListView lv;
    ArrayAdapter<String> adapter;
	HashMap<String,Integer> mSongs = new HashMap<String,Integer>();

String songs[]={"1- Mtakatifu, Mtakatifu, Mtakatifu.","2- Twamsifu Mungu","3- Mungu Atukuzwe","4- Jina Ya Yesu, Salamu",
		"5- Na Tumwabudu Mfalme Mtukufu","6- Kumekucha Kwa Uzuri","7- Mungu Msaada Wetu","8- Uje Mkombozi","9- Mwumbaji, Mfalme",
		"10- Kristo Wa Neema Yote","11- Jina La Bwana Li Heri","12- Msifu Mungu","13- Yesu Uje Kwetu","14- Nitembee Nawe",
		"15- Nena Mungu","16- Ninakuhitaji","17- Si Mimi, Kristo","18- Mwokozi Kama Mchunga","19- Msalabani Pa Mwokozi",
		"20- Mungu Wetu Yeye Mwamba","21- Baba Twakujia","22- Usinipite","23- Yesu Furaha Ya Myoyo","24- Jina Lake Yesu Tamu",
		"25- Taji Mvikeni","26- Tutokapo Tubariki","26a- Tupe Amani","27- Tena, Mwokozi, Twalitukuza Jina Lako","28- Jina La Thamani",
		"29- Yesu, Nakupenda","30- Yesu Unipendaye","31- Niimbe Pendo Lake","32- Tangu Kuamini","33- Karibu Sana",
		"34- Hadithia Kisa Cha Yesu","35- Nimekombolewa Na Yesu","36- Siku Kuu","37- Pendo Lako, Ee Mwokozi",
		"38- Nasifu Shani Ya Mungu","39- Ati, Kuna Mvua Njema","40- Nijaze Sasa","41- Roho Mtakatifu","42- Ewe Roho Wa Mbinguni",
		"43- Furaha Gani","44- Urafiki Wa Yesu","45- Mwanga Umo Moyoni","46- Miguuni Pake Yesu","47- Ni Heri Kifungo",
		"48- Ninakupenda Zaidi","49- Ninaye Rafiki","50- Mungu Nawe Nanyi Daima","51- Kuwa Na Yesu","52- Nipe Biblia",
		"53- Napenda Kuhubiri","54- Nataka Nimjue Yesu","55- Twapanda Mapema","56- Waponyeni Watu","57- Usikatae Kazi",
		"58- Zitakuwa Nyota Tajini?","59- Fanyeni Kazi Zenu","60- Nitakwenda Utakaponituma","61- Bwana, Nami",
		"62- Napenda Kitabu Chake","63- Niuonapo Msalaba","64- Piga Panda","65- Twendeni Askari","66- Roho Yangu Amka Sasa",
		"67- Kesha Roho Yangu","68- Tusimame Imara Mwambani","69- Cha Kutumaini Sina","70- Wapenzi Wa Bwana","71- Kesheni Kaombeni",
		"72- Jenga Juu Ya Mwamba","73- 'Bwana, Uniongoze Juu'","74- Niambie, Ee Mlinzi","75- Msingi Imara, Ninyi Wa Bwana",
		"76- Mrithi Ufalme","77- Habari Za Usiku","78- Mpaka Lini Bwana?","79- Nataka Imani Hii","80- Tupe Moto Wa Uhai",
		"81- Siku Sita Zimepita","82- Ni Siku Ya Furaha","83- Ewe Skuli Ya Sabato","84- Ikumbuke Sabato","85- Salama Tumepita",
		"86- Ukaribie Tena","87- Siku Ya Sabato","88- Siku Hii Ya Sabato","89- Asubuhi","90- Mapya Ni Mapenzi","91- Kaa Nami",
		"92- Magharibi Jua","93- Jua La Rohoni Mwangu","94- Po Pote Mashamba Yajaa","95- Zileteni Zaka Kwa Hazina",
		"96- Mali Yako Sasa","97- Sioshwi Dhambi Zangu","98- Nilikupa Wewe","99- Twende Kwa Yesu","100- Kuwatafuta",
		"101- Yesu Akwita","102- Mlangoni Pa Moyo","103- Njoni Kwangu","104- Yesu Aliniita. 'Njoo'",
		"105- Mchungaji Mpenzi","106- Huna Kitu Kwa Yesu","107- Nipo Bwana, Nitume","108- Tumesikia Mbiu","109- Anisikiaye",
		"110- Mlango Wazi","111- Tabibu Mkuu","112- Wewe Umechoka Sana?","113- Bubujiko","114- Yesu Nataka Kutakaswa Sana",
		"115- Naendea Msalaba","116- Moyo Safi","117- Wamwendea Yesu","118- Nilipotoka Kabisa","119- Alilipa Bei",
		"120- Msalaba Wa Yesu","121- Katika Wenye Dhambi","122- Yote Namtolea Yesu",
		"123- Yesu Kwa Imani","124- Umechokaje Umesumbuka","125- Uniangalie","126- Nina Haja Nawe","127- Ni Salama Rohoni Mwangu",
		"128- Taamini Nitii Pia","129- Kumtegemea Mwokozi","130- Yesu Kwetu Ni Rafiki","131- Baba Anilinda",
		"131a- Kwa Mahitaji Ya Kesho","132- Bwana Ni Mchunga","133- Po Pote Na Yesu","134- Tafuta Daima Utakatifu",
		"135- Kwa Maombi Nachangamka","136- Niwe Kama Yesu","137- Saa Heri Ya Sala",
		"138- Nitakuandama Kote","139- Uliniimbie Tena","140- Hivi Nilivyo Unitwae","141- Chini Ya Msalaba",
		"142- Nasikia Sauti Yako","143- Naamini","144- Ni Wako Bwana","145- Namtaka Bwana Yesu","146- Twae Wangu Uzima",
		"147- Uishi Ndani Yangu","148- Univute Karibu","149- Kuwa Wake Yesu","150- Hasha, Maneno Mabaya Yasitoke",
		"151- Huniongoza Mwongozi","152- Karibu Na Wewe, Mungu Wangu","153- Fikira Moja Tu",
		"154- Yanipasa Kuwa Naye","155- Njiani Huniongoza","156- Uniongoze, Yehova","157- Mfalme Yu Mlangoni",
		"158- U Mwendo Gani Nyumbani?","159- Anakuja Upesi","160- Watakatifu Kesheni","161- Piga Panda","162- Tumaini Liko",
		"163- Anakuja, Bwana Yesu","164- Mishale Ya Nuru","165- 'Uwe Imara'","166- Furaha Kwa Ulimwengu","167- Yu Hai, Yu Hai",
		"168- Tarumbeta Ya Mwana","169- Tutashindaje Hukumuni?","170- Jina Langu Limeandikwa Je?",
		"171- Hukumu","172- Mfalme Ajapo","173- Hatujui Saa","174- Tukimngojea","175- Uso Kwa Uso","176- Ati Tuonane Mtoni?",
		"177- Kazi Yangu Ikiisha","178- Ukingoni Mwa Yordani","179- Watafurahi","180- Pana Mahali Pazuri Mno",
		"181- Tutakaa Mahali Pa Maji","182- Hapana Giza","183- Yesu Anaporudi","184- Panapo Pendo","185- Mungu, Mapenzi Makamilifu",
		"186- Hatutaagana Tena","187- Kufariki Naye Yesu","188- Wimbi Litakasalo","189- Tubatize Upya",
		"190- Raha Yangu Yote, Bwana","191- Mkate Wa Mbingu","192- Mwamba Wenye Imara","193- Sauti Yake Mchungaji",
		"194- Twaomba Baraka Zako","195- Msingi Wa Kanisa","196- Vito Vya Thamani","197- Ananipenda Ni Kweli",
		"198- Kaza Sana Macho","199- Upendo Ni Furaha","200- Baba Yetu Aliye Mbinguni","201- Hunipenda Pia","202- Sikia Mlio",
		"203- Ya Saba Ni Kwa Yesu","204- Kuwa Na Yesu Nyumbani","205- Msifu Mungu Ee Watoto",
		"206- Mwokozi Wangu Anipenda","207- Nani Afanya Maua","208- Mungu Afanya Upindi","209- Napenda Sana Kufika",
		"210- Roho Wa Mungu","211- Moyoni","212- Mtazame Mwokozi","213- Niwe Nao Uzuri Wa Mwokozi","214- Nataka Niwe Tayari",
		"215- Ulimwengu Wataka","216- Moyoni 'Nijaze","217- Omba Sana Asubuhi","218- Yesu Mwokozi Mpendwa","219- Pambazuka Nuru",
		"220- Kwa Heri"};
	Intent intent = null;

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	//	setListAdapter(new ArrayAdapter<String>(this,R.layout.songlist,songs));
       //setContentView(R.layout.songlist);

		for(int c = 0;c < songs.length; c++){
			mSongs.put(songs[c],c);
		}

		lv = (ListView)findViewById(R.id.lstView);
		lv = getListView();
		adapter = new ArrayAdapter(this,R.layout.songlist,R.id.textView1,songs);
		lv.setDividerHeight(2);
		lv.setAdapter(adapter);

        handleIntent(getIntent());

		lv.setOnItemClickListener(new OnItemClickListener() {
		@Override
			public void onItemClick(AdapterView<?>arg0, View arg1, int pos,long arg3){
			String val = adapter.getItem(pos);
			Toast.makeText(SongList.this,val,Toast.LENGTH_SHORT).show();
			int position = mSongs.get(val);
			if(position==0){
					intent = new Intent (SongList.this,H1.class);
					startActivity(intent);
					}
				if(position==1){
					intent = new Intent (SongList.this,H2.class);
					startActivity(intent);
					}
				if(position==2){
					intent = new Intent (SongList.this,H3.class);
					startActivity(intent);
					}
				if(position==3){
					intent = new Intent (SongList.this,H4.class);
					startActivity(intent);
					}
				if(position==4){
					intent = new Intent (SongList.this,H5.class);
					startActivity(intent);
					}
				if(position==5){
					intent = new Intent (SongList.this,H6.class);
					startActivity(intent);
					}
				if(position==6){
					intent = new Intent (SongList.this,H7.class);
					startActivity(intent);
					}
				if(position==7){
					intent = new Intent (SongList.this,H8.class);
					startActivity(intent);
					}
				if(position==8){
					intent = new Intent (SongList.this,H9.class);
					startActivity(intent);
					}
				if(position==9){
					intent = new Intent (SongList.this,H10.class);
					startActivity(intent);
					}
				if(position==10){
					intent = new Intent (SongList.this,H11.class);
					startActivity(intent);
					}
				if(position==11){
					intent = new Intent (SongList.this,H12.class);
					startActivity(intent);
					}
				if(position==12){
					intent = new Intent (SongList.this,H13.class);
					startActivity(intent);
					}
				if(position==13){
					intent = new Intent (SongList.this,H14.class);
					startActivity(intent);
					}
				if(position==14){
					intent = new Intent (SongList.this,H15.class);
					startActivity(intent);
					}
				if(position==15){
					intent = new Intent (SongList.this,H16.class);
					startActivity(intent);
					}
				if(position==16){
					intent = new Intent (SongList.this,H17.class);
					startActivity(intent);
					}
				if(position==17){
					intent = new Intent (SongList.this,H18.class);
					startActivity(intent);
					}
				if(position==18){
					intent = new Intent (SongList.this,H19.class);
					startActivity(intent);
					}
				if(position==19){
					intent = new Intent (SongList.this,H20.class);
					startActivity(intent);
					}
				if(position==20){
					intent = new Intent (SongList.this,H21.class);
					startActivity(intent);
					}
				if(position==21){
					intent = new Intent (SongList.this,H22.class);
					startActivity(intent);
					}
				if(position==22){
					intent = new Intent (SongList.this,H23.class);
					startActivity(intent);
					}
				if(position==23){
					intent = new Intent (SongList.this,H24.class);
					startActivity(intent);
					}
				if(position==24){
					intent = new Intent (SongList.this,H25.class);
					startActivity(intent);
					}
				if(position==25){
					intent = new Intent (SongList.this,H26.class);
					startActivity(intent);
					}
				if(position==26){
					intent = new Intent (SongList.this,H26a.class);
					startActivity(intent);
					}
				if(position==27){
					intent = new Intent (SongList.this,H27.class);
					startActivity(intent);
					}
				if(position==28){
					intent = new Intent (SongList.this,H28.class);
					startActivity(intent);
					}
				if(position==29){
					intent = new Intent (SongList.this,H29.class);
					startActivity(intent);
					}
				if(position==30){
					intent = new Intent (SongList.this,H30.class);
					startActivity(intent);
					}
				if(position==31){
					intent = new Intent (SongList.this,H31.class);
					startActivity(intent);
					}
				if(position==32){
					intent = new Intent (SongList.this,H32.class);
					startActivity(intent);
					}
				if(position==33){
					intent = new Intent (SongList.this,H33.class);
					startActivity(intent);
					}
				if(position==34){
					intent = new Intent (SongList.this,H34.class);
					startActivity(intent);
					}
				if(position==35){
					intent = new Intent (SongList.this,H35.class);
					startActivity(intent);
					}
				if(position==36){
					intent = new Intent (SongList.this,H36.class);
					startActivity(intent);
					}
				if(position==37){
					intent = new Intent (SongList.this,H37.class);
					startActivity(intent);
					}
				if(position==38){
					intent = new Intent (SongList.this,H38.class);
					startActivity(intent);
					}
				if(position==39){
					intent = new Intent (SongList.this,H39.class);
					startActivity(intent);
					}
				if(position==40){
					intent = new Intent (SongList.this,H40.class);
					startActivity(intent);
					}
				if(position==41){
					intent = new Intent (SongList.this,H41.class);
					startActivity(intent);
					}
				if(position==42){
					intent = new Intent (SongList.this,H42.class);
					startActivity(intent);
					}
				if(position==43){
					intent = new Intent (SongList.this,H43.class);
					startActivity(intent);
					}
				if(position==44){
					intent = new Intent (SongList.this,H44.class);
					startActivity(intent);
					}
				if(position==45){
					intent = new Intent (SongList.this,H45.class);
					startActivity(intent);
					}
				if(position==46){
					intent = new Intent (SongList.this,H46.class);
					startActivity(intent);
					}
				if(position==47){
					intent = new Intent (SongList.this,H47.class);
					startActivity(intent);
					}
				if(position==48){
					intent = new Intent (SongList.this,H48.class);
					startActivity(intent);
					}
				if(position==49){
					intent = new Intent (SongList.this,H49.class);
					startActivity(intent);
					}
				if(position==50){
					intent = new Intent (SongList.this,H50.class);
					startActivity(intent);
					}
				if(position==51){
					intent = new Intent (SongList.this,H51.class);
					startActivity(intent);
					}
				if(position==52){
					intent = new Intent (SongList.this,H52.class);
					startActivity(intent);
					}
				if(position==53){
					intent = new Intent (SongList.this,H53.class);
					startActivity(intent);
					}
				if(position==54){
					intent = new Intent (SongList.this,H54.class);
					startActivity(intent);
					}
				if(position==55){
					intent = new Intent (SongList.this,H55.class);
					startActivity(intent);
					}
				if(position==56){
					intent = new Intent (SongList.this,H56.class);
					startActivity(intent);
					}
				if(position==57){
					intent = new Intent (SongList.this,H57.class);
					startActivity(intent);
					}
				if(position==58){
					intent = new Intent (SongList.this,H58.class);
					startActivity(intent);
					}
				if(position==59){
					intent = new Intent (SongList.this,H59.class);
					startActivity(intent);
					}
				if(position==60){
					intent = new Intent (SongList.this,H60.class);
					startActivity(intent);
					}
				if(position==61){
					intent = new Intent (SongList.this,H61.class);
					startActivity(intent);
					}
				if(position==62){
					intent = new Intent (SongList.this,H62.class);
					startActivity(intent);
					}
				if(position==63){
					intent = new Intent (SongList.this,H63.class);
					startActivity(intent);
					}
				if(position==64){
					intent = new Intent (SongList.this,H64.class);
					startActivity(intent);
					}
				if(position==65){
					intent = new Intent (SongList.this,H65.class);
					startActivity(intent);
					}
				if(position==66){
					intent = new Intent (SongList.this,H66.class);
					startActivity(intent);
					}
				if(position==67){
					intent = new Intent (SongList.this,H67.class);
					startActivity(intent);
					}
				if(position==68){
					intent = new Intent (SongList.this,H68.class);
					startActivity(intent);
					}
				if(position==69){
					intent = new Intent (SongList.this,H69.class);
					startActivity(intent);
					}
				if(position==70){
					intent = new Intent (SongList.this,H70.class);
					startActivity(intent);
					}
				if(position==71){
					intent = new Intent (SongList.this,H71.class);
					startActivity(intent);
					}
				if(position==72){
					intent = new Intent (SongList.this,H72.class);
					startActivity(intent);
					}
				if(position==73){
					intent = new Intent (SongList.this,H73.class);
					startActivity(intent);
					}
				if(position==74){
					intent = new Intent (SongList.this,H74.class);
					startActivity(intent);
					}
				if(position==75){
					intent = new Intent (SongList.this,H75.class);
					startActivity(intent);
					}
				if(position==76){
					intent = new Intent (SongList.this,H76.class);
					startActivity(intent);
					}
				if(position==77){
					intent = new Intent (SongList.this,H77.class);
					startActivity(intent);
					}
				if(position==78){
					intent = new Intent (SongList.this,H78.class);
					startActivity(intent);
					}
				if(position==79){
					intent = new Intent (SongList.this,H79.class);
					startActivity(intent);
					}
				if(position==80){
					intent = new Intent (SongList.this,H80.class);
					startActivity(intent);
					}
				if(position==81){
					intent = new Intent (SongList.this,H81.class);
					startActivity(intent);
					}
				if(position==82){
					intent = new Intent (SongList.this,H82.class);
					startActivity(intent);
					}
				if(position==83){
					intent = new Intent (SongList.this,H83.class);
					startActivity(intent);
					}
				if(position==84){
					intent = new Intent (SongList.this,H84.class);
					startActivity(intent);
					}
				if(position==85){
					intent = new Intent (SongList.this,H85.class);
					startActivity(intent);
					}
				if(position==86){
					intent = new Intent (SongList.this,H86.class);
					startActivity(intent);
					}
				if(position==87){
					intent = new Intent (SongList.this,H87.class);
					startActivity(intent);
					}
				if(position==88){
					intent = new Intent (SongList.this,H88.class);
					startActivity(intent);
					}
				if(position==89){
					intent = new Intent (SongList.this,H89.class);
					startActivity(intent);
					}
				if(position==90){
					intent = new Intent (SongList.this,H90.class);
					startActivity(intent);
					}
				if(position==91){
					intent = new Intent (SongList.this,H91.class);
					startActivity(intent);
					}
				if(position==92){
					intent = new Intent (SongList.this,H92.class);
					startActivity(intent);
					}
				if(position==93){
					intent = new Intent (SongList.this,H93.class);
					startActivity(intent);
					}
				if(position==94){
					intent = new Intent (SongList.this,H94.class);
					startActivity(intent);
				}
				if(position==95){
					intent = new Intent (SongList.this,H95.class);
					startActivity(intent);
					}
				if(position==96){
					intent = new Intent (SongList.this,H96.class);
					startActivity(intent);
					}
				if(position==97){
					intent = new Intent (SongList.this,H97.class);
					startActivity(intent);
					}
				if(position==98){
					intent = new Intent (SongList.this,H98.class);
					startActivity(intent);
				}
				if(position==99){
					intent = new Intent (SongList.this,H99.class);
					startActivity(intent);
					}
				if(position==100){
					intent = new Intent (SongList.this,H100.class);
					startActivity(intent);
					}
				if(position==101){
					intent = new Intent (SongList.this,H101.class);
					startActivity(intent);
					}

				if(position==102){
					intent = new Intent (SongList.this,H102.class);
					startActivity(intent);
					}
				if(position==103){
					intent = new Intent (SongList.this,H103.class);
					startActivity(intent);
					}
				if(position==104){
					intent = new Intent (SongList.this,H104.class);
					startActivity(intent);
					}
				if(position==105){
					intent = new Intent (SongList.this,H105.class);
					startActivity(intent);
					}
				if(position==106){
					intent = new Intent (SongList.this,H106.class);
					startActivity(intent);
					}
				if(position==107){
					intent = new Intent (SongList.this,H107.class);
					startActivity(intent);
					}
				if(position==108){
					intent = new Intent (SongList.this,H108.class);
					startActivity(intent);
					}
				if(position==109){
					intent = new Intent (SongList.this,H109.class);
					startActivity(intent);
					}
				if(position==110){
					intent = new Intent (SongList.this,H110.class);
					startActivity(intent);
					}
				if(position==111){
					intent = new Intent (SongList.this,H111.class);
					startActivity(intent);
					}
				if(position==112){
					intent = new Intent (SongList.this,H112.class);
					startActivity(intent);
					}
				if(position==113){
					intent = new Intent (SongList.this,H113.class);
					startActivity(intent);
					}
				if(position==114){
					intent = new Intent (SongList.this,H114.class);
					startActivity(intent);
					}
				if(position==115){
					intent = new Intent (SongList.this,H115.class);
					startActivity(intent);
					}
				if(position==116){
					intent = new Intent (SongList.this,H116.class);
					startActivity(intent);
					}
				if(position==117){
					intent = new Intent (SongList.this,H117.class);
					startActivity(intent);
					}
				if(position==118){
					intent = new Intent (SongList.this,H118.class);
					startActivity(intent);
					}
				if(position==119){
					intent = new Intent (SongList.this,H119.class);
					startActivity(intent);
					}
				if(position==120){
					intent = new Intent (SongList.this,H120.class);
					startActivity(intent);
					}
				if(position==121){
					intent = new Intent (SongList.this,H121.class);
					startActivity(intent);
					}
				if(position==122){
					intent = new Intent (SongList.this,H122.class);
					startActivity(intent);
					}
				if(position==123){
					intent = new Intent (SongList.this,H123.class);
					startActivity(intent);
					}
				if(position==124){
					intent = new Intent (SongList.this,H124.class);
					startActivity(intent);
					}
				if(position==125){
					intent = new Intent (SongList.this,H125.class);
					startActivity(intent);
					}
				if(position==126){
					intent = new Intent (SongList.this,H126.class);
					startActivity(intent);
					}
				if(position==127){
					intent = new Intent (SongList.this,H127.class);
					startActivity(intent);
					}
				if(position==128){
					intent = new Intent (SongList.this,H128.class);
					startActivity(intent);
					}
				if(position==129){
					intent = new Intent (SongList.this,H129.class);
					startActivity(intent);
					}
				if(position==130){
					intent = new Intent (SongList.this,H130.class);
					startActivity(intent);
					}
				if(position==131){
					intent = new Intent (SongList.this,H131.class);
					startActivity(intent);
					}
				if(position==132){
					intent = new Intent (SongList.this,H131a.class);
					startActivity(intent);
					}
				if(position==133){
					intent = new Intent (SongList.this,H132.class);
					startActivity(intent);
					}
				if(position==134){
					intent = new Intent (SongList.this,H133.class);
					startActivity(intent);
					}
				if(position==135){
					intent = new Intent (SongList.this,H134.class);
					startActivity(intent);
					}
				if(position==136){
					intent = new Intent (SongList.this,H135.class);
					startActivity(intent);
					}
				if(position==137){
					intent = new Intent (SongList.this,H136.class);
					startActivity(intent);
					}
				if(position==138){
					intent = new Intent (SongList.this,H137.class);
					startActivity(intent);
					}
				if(position==139){
					intent = new Intent (SongList.this,H138.class);
					startActivity(intent);
					}
				if(position==140){
					intent = new Intent (SongList.this,H139.class);
					startActivity(intent);
					}
				if(position==141){
					intent = new Intent (SongList.this,H140.class);
					startActivity(intent);
					}
				if(position==142){
					intent = new Intent (SongList.this,H141.class);
					startActivity(intent);
					}
				if(position==143){
					intent = new Intent (SongList.this,H142.class);
					startActivity(intent);
					}
				if(position==144){
					intent = new Intent (SongList.this,H143.class);
					startActivity(intent);
					}
				if(position==145){
					intent = new Intent (SongList.this,H144.class);
					startActivity(intent);
					}
				if(position==146){
					intent = new Intent (SongList.this,H145.class);
					startActivity(intent);
					}
				if(position==147){
					intent = new Intent (SongList.this,H146.class);
					startActivity(intent);
					}
				if(position==148){
					intent = new Intent (SongList.this,H147.class);
					startActivity(intent);
					}
				if(position==149){
					intent = new Intent (SongList.this,H148.class);
					startActivity(intent);
					}
				if(position==150){
					intent = new Intent (SongList.this,H149.class);
					startActivity(intent);
					}
				if(position==151){
					intent = new Intent (SongList.this,H150.class);
					startActivity(intent);
					}
				if(position==152){
					intent = new Intent (SongList.this,H151.class);
					startActivity(intent);
					}
				if(position==153){
					intent = new Intent (SongList.this,H152.class);
					startActivity(intent);
					}
				if(position==154){
					intent = new Intent (SongList.this,H153.class);
					startActivity(intent);
					}
				if(position==155){
					intent = new Intent (SongList.this,H154.class);
					startActivity(intent);
					}
				if(position==156){
					intent = new Intent (SongList.this,H155.class);
					startActivity(intent);
					}
				if(position==157){
					intent = new Intent (SongList.this,H156.class);
					startActivity(intent);
					}
				if(position==158){
					intent = new Intent (SongList.this,H157.class);
					startActivity(intent);
					}
				if(position==159){
					intent = new Intent (SongList.this,H158.class);
					startActivity(intent);
					}
				if(position==160){
					intent = new Intent (SongList.this,H159.class);
					startActivity(intent);
					}
				if(position==161){
					intent = new Intent (SongList.this,H160.class);
					startActivity(intent);
					}
				if(position==162){
					intent = new Intent (SongList.this,H161.class);
					startActivity(intent);
					}
				if(position==163){
					intent = new Intent (SongList.this,H162.class);
					startActivity(intent);
					}
				if(position==164){
					intent = new Intent (SongList.this,H163.class);
					startActivity(intent);
					}
				if(position==165){
					intent = new Intent (SongList.this,H164.class);
					startActivity(intent);
					}
				if(position==166){
					intent = new Intent (SongList.this,H165.class);
					startActivity(intent);
					}
				if(position==167){
					intent = new Intent (SongList.this,H166.class);
					startActivity(intent);
					}
				if(position==168){
					intent = new Intent (SongList.this,H167.class);
					startActivity(intent);
					}
				if(position==169){
					intent = new Intent (SongList.this,H168.class);
					startActivity(intent);
					}
				if(position==170){
					intent = new Intent (SongList.this,H169.class);
					startActivity(intent);
					}
				if(position==171){
					intent = new Intent (SongList.this,H170.class);
					startActivity(intent);
					}
				if(position==172){
					intent = new Intent (SongList.this,H171.class);
					startActivity(intent);
					}
				if(position==173){
					intent = new Intent (SongList.this,H172.class);
					startActivity(intent);
					}
				if(position==174){
					intent = new Intent (SongList.this,H173.class);
					startActivity(intent);
					}
				if(position==175){
					intent = new Intent (SongList.this,H174.class);
					startActivity(intent);
					}
				if(position==176){
					intent = new Intent (SongList.this,H175.class);
					startActivity(intent);
					}
				if(position==177){
					intent = new Intent (SongList.this,H176.class);
					startActivity(intent);
					}
				if(position==178){
					intent = new Intent (SongList.this,H177.class);
					startActivity(intent);
					}
				if(position==179){
					intent = new Intent (SongList.this,H178.class);
					startActivity(intent);
					}
				if(position==180){
					intent = new Intent (SongList.this,H179.class);
					startActivity(intent);
					}
				if(position==181){
					intent = new Intent (SongList.this,H180.class);
					startActivity(intent);
					}
				if(position==182){
					intent = new Intent (SongList.this,H181.class);
					startActivity(intent);
					}
				if(position==183){
					intent = new Intent (SongList.this,H182.class);
					startActivity(intent);
					}
				if(position==184){
					intent = new Intent (SongList.this,H183.class);
					startActivity(intent);
					}
				if(position==185){
					intent = new Intent (SongList.this,H184.class);
					startActivity(intent);
					}
				if(position==186){
					intent = new Intent (SongList.this,H185.class);
					startActivity(intent);
					}
				if(position==187){
					intent = new Intent (SongList.this,H186.class);
					startActivity(intent);
					}
				if(position==188){
					intent = new Intent (SongList.this,H187.class);
					startActivity(intent);
					}
				if(position==189){
					intent = new Intent (SongList.this,H188.class);
					startActivity(intent);
					}
				if(position==190){
					intent = new Intent (SongList.this,H189.class);
					startActivity(intent);
					}
				if(position==191){
					intent = new Intent (SongList.this,H190.class);
					startActivity(intent);
					}
				if(position==192){
					intent = new Intent (SongList.this,H191.class);
					startActivity(intent);
					}
				if(position==193){
					intent = new Intent (SongList.this,H192.class);
					startActivity(intent);
					}
				if(position==194){
					intent = new Intent (SongList.this,H193.class);
					startActivity(intent);
					}
				if(position==195){
					intent = new Intent (SongList.this,H194.class);
					startActivity(intent);
				}
				if(position==196){
					intent = new Intent (SongList.this,H195.class);
					startActivity(intent);
					}
				if(position==197){
					intent = new Intent (SongList.this,H196.class);
					startActivity(intent);
					}
				if(position==198){
					intent = new Intent (SongList.this,H197.class);
					startActivity(intent);
					}
				if(position==199){
					intent = new Intent (SongList.this,H198.class);
					startActivity(intent);
				}
				if(position==200){
					intent = new Intent (SongList.this,H199.class);
					startActivity(intent);
					}
				if(position==201){
					intent = new Intent (SongList.this,H200.class);
					startActivity(intent);
					}
				if(position==202){
					intent = new Intent (SongList.this,H201.class);
					startActivity(intent);
					}

				if(position==203){
					intent = new Intent (SongList.this,H202.class);
					startActivity(intent);
					}
				if(position==204){
					intent = new Intent (SongList.this,H203.class);
					startActivity(intent);
					}
				if(position==205){
					intent = new Intent (SongList.this,H204.class);
					startActivity(intent);
					}
				if(position==206){
					intent = new Intent (SongList.this,H205.class);
					startActivity(intent);
					}
				if(position==207){
					intent = new Intent (SongList.this,H206.class);
					startActivity(intent);
					}
				if(position==208){
					intent = new Intent (SongList.this,H207.class);
					startActivity(intent);
					}
				if(position==209){
					intent = new Intent (SongList.this,H208.class);
					startActivity(intent);
					}
				if(position==210){
					intent = new Intent (SongList.this,H209.class);
					startActivity(intent);
					}
				if(position==211){
					intent = new Intent (SongList.this,H210.class);
					startActivity(intent);
					}
				if(position==212){
					intent = new Intent (SongList.this,H211.class);
					startActivity(intent);
					}
				if(position==213){
					intent = new Intent (SongList.this,H212.class);
					startActivity(intent);
					}
				if(position==214){
					intent = new Intent (SongList.this,H213.class);
					startActivity(intent);
					}
				if(position==215){
					intent = new Intent (SongList.this,H214.class);
					startActivity(intent);
					}
				if(position==216){
					intent = new Intent (SongList.this,H215.class);
					startActivity(intent);
					}
				if(position==217){
					intent = new Intent (SongList.this,H216.class);
					startActivity(intent);
					}
				if(position==218){
					intent = new Intent (SongList.this,H217.class);
					startActivity(intent);
					}
				if(position==219){
					intent = new Intent (SongList.this,H218.class);
					startActivity(intent);
					}
				if(position==220){
					intent = new Intent (SongList.this,H219.class);
					startActivity(intent);
					}
				if(position==221){
					intent = new Intent (SongList.this,H220.class);
					startActivity(intent);
					}
		}


});
}

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.searchmenu, menu);

        SearchManager searchmanager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();

        searchView.setSearchableInfo(searchmanager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
		searchView.setSubmitButtonEnabled(false);

		return true;
	}

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //use the query to search your data somehow
        }
    }


    public boolean onQueryTextSubmit(String query){
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);

        return true;
    }

    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub

	}


}