package com.wstro.util;

import com.wstro.entity.SsqBonusEntity;
import org.apache.commons.collections.BagUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 双色球网站往期信息抓取
 */
public class SsqJsoup {

    private static final Logger logger = LoggerFactory.getLogger(SsqJsoup.class);

    private static String ssqUrl="http://datachart.500.com/ssq/history/newinc/history.php";

    private static Integer[] blue =new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
    private static Integer[] red =new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};

    public static List<SsqBonusEntity>  parse(){
        List<SsqBonusEntity> list=new ArrayList<>();
        try {
            Document doc=Jsoup.parse(new URL(ssqUrl).openStream(), "GBK", ssqUrl);
            Element tbody= doc.getElementById("tdata");
            Elements trs= tbody.getElementsByTag("tr");
            if (trs !=null && trs.size()>0){
                for (Element trnode:trs){
                    SsqBonusEntity entity=new SsqBonusEntity();
                    Elements td= trnode.getElementsByTag("td");
                    entity.setId(Integer.valueOf(td.get(0).text()));
                    entity.setOne(td.get(1).text());
                    entity.setTwo(td.get(2).text());
                    entity.setThree(td.get(3).text());
                    entity.setFour(td.get(4).text());
                    entity.setFive(td.get(5).text());
                    entity.setSix(td.get(6).text());
                    entity.setSeven(td.get(7).text());
                    entity.setBonusPool(td.get(9).text());
                    entity.setOneNotes(Integer.valueOf(td.get(10).text()));
                    entity.setOneBonus(td.get(11).text());
                    entity.setTwoNotes(Integer.valueOf(td.get(12).text()));
                    entity.setTwoBonus(td.get(13).text());
                    entity.setTotalBonus(td.get(14).text());
                    entity.setOpenBounsDate(DateUtils.parse(td.get(15).text()));
                    list.add(entity);
                }
            }
        }catch (Exception e){
            logger.error("抓取双色球彩票出错，错误信息：",e);
        }
        return list;
    }

    public static List<Integer> shuff(){
        List<Integer> result=new ArrayList<>();
        List<Integer> blueList= Arrays.asList(blue);
        int a=ball(blueList);
        result.add(a);
        List<Integer> twoList=blueList.stream().filter(s -> s != a).collect(Collectors.toList());
        int b=ball(twoList);
        result.add(b);
        List<Integer> threeList=twoList.stream().filter(s -> s!=b).collect(Collectors.toList());
        int c=ball(threeList);
        result.add(c);
        List<Integer> fourList=threeList.stream().filter(s -> s!=c).collect(Collectors.toList());
        int d=ball(fourList);
        result.add(d);
        List<Integer>fiveList=fourList.stream().filter(s -> s!=d).collect(Collectors.toList());
        int e=ball(fiveList);
        result.add(e);
        List<Integer>sixList=fiveList.stream().filter(s-> s!=e).collect(Collectors.toList());
        int f=ball(sixList);
        result.add(f);
        Collections.sort(result);
        //获取红球
        List<Integer> redBall=Arrays.asList(red);
        int red=ball(redBall);
        result.add(red);
        return result;
    }


    /**
     * 从集里随机获取一个值
     * @param list
     * @return
     */
    private static int ball(List<Integer> list){
        Random r = new Random();
        Collections.shuffle(list);
        Collections.shuffle(list);
        Collections.shuffle(list);
        Collections.shuffle(list);
        Collections.shuffle(list);
        int n=r.nextInt(list.size());
        return list.get(n);
    }

}
