package com.example.dijkstra_algoritm.controller;

import com.example.dijkstra_algoritm.constructor.EdgeGraphConstructor;
import com.example.dijkstra_algoritm.constructor.VerticesGraphConstructor;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class DrawGraph {

//        /** Рандомное создание таблицы положений и значений вершин графа.
//    * Принимает -numOfVert- численное значение количества вершин.
//    * Возвращает ArrayList<VerticesGraph> - Рандомно заполненый список со значениями положения вершин.
//    */
//    static ArrayList<VerticesGraph> CreateRandomVert(int numOfVert) {
//
//
//        ArrayList<VerticesGraph> randomVertCoord = new ArrayList<>();
//        int[][] Coord = new int[numOfVert][2];
//
//        for (int i = 0; i < numOfVert; i++){
//            Coord[i][0] = ThreadLocalRandom.current().nextInt(30, 470); //Генерация ранндомных значений в диапазоне от 30 до 470 px.
//            Coord[i][1] = ThreadLocalRandom.current().nextInt(30, 470);
//            randomVertCoord.add(new VerticesGraph(Coord[i][0],Coord[i][1],i,-1,Color.WHITE)); //Добавление в список через создание экземпляра класса (Координата X, Координата Y, Номер вершины, Начальный цвет).
//        }
//
//        return randomVertCoord;
//    }




//
//    /** Создание шаблона вершины
//      Принимает randomVertCoord с типом ArrayList<VerticesGraph> - Список рандомных значение созданный в CreateRandomVert.
//      Возвращает ArrayList<Node> - Создынный список скомпанованных вешин.
//     */
//    protected ArrayList<Node> drawObj(ArrayList<VerticesGraph> randomVertCoord){
//        ArrayList<Node> drObj = new ArrayList<>();
//
//
//        for (int i = 0; i < randomVertCoord.size();i++){
//            VerticesGraph listVert = randomVertCoord.get(i);
//            x = listVert.x;
//            y = listVert.y;
//            number = listVert.number;
//            BGcolor = listVert.BGcolor;
//            drObj.add(drawCirVert(x,y));
//            drObj.add(drawCirVertIn(x,y,BGcolor));
//            drObj.add(drawTextVert(x,y,number));
//
//        }
//        return drObj;
//    }


    //    /** Создание ребер графа
//     * Принимает Два экземпляра класса вершин "VerticesGraph", значение От и До для генерации веса ребер
//     * Возвращает заполненый список ребер графа с типом ArrayList<Node> */
//    public static ArrayList<Node> createLineForVert (VerticesGraph a, VerticesGraph b,int from, int to){
//        ArrayList<Node> list = new ArrayList<>();
//
//        int massInt = ThreadLocalRandom.current().nextInt(from, to);
//        //Расчет центра ребра.
//        int x = compMax(a.getX(),b.getX()) - Math.abs(a.getX() - b.getX())/2;
//        int y = compMax(a.getY(),b.getY()) - Math.abs(a.getY() - b.getY())/2;
//
//        Text mass = new Text(x-10, y-8, String.valueOf(massInt));
//        mass.setFont(Font.font(16));
//        Line line = new Line(a.getX(), a.getY(), b.getX(), b.getY());
//        list.add(line);
//        list.add(mass);
//
//        return list;
//    }
//




    /** Метод сравнения двух переменных
     * Принимает две переменные типа Integer
     * Возвращает значение или -1 */
    private static int compMax(int a, int b){
        if (a > b) {
            return a;
        } else if (b > a) {
            return b;
        } else {
            return -1;
        }
    }



    /** Создание ребра между вершиной А и вершиной Б с массой mass
     * Принимает Два экземпляра класса вершин "VerticesGraphConstructor", значение mass - вес ребра
     * Возвращает список ребера графа с типом ArrayList<Node> который содержит  */
    public ArrayList<Node> drawEdge(EdgeGraphConstructor edge){

        //Расчет центра ребра.
        int x = compMax(edge.getVertA().getX(), edge.getVertB().getX()) - Math.abs(edge.getVertA().getX() - edge.getVertB().getX())/2;
        int y = compMax(edge.getVertA().getY(), edge.getVertB().getY()) - Math.abs(edge.getVertA().getY() - edge.getVertB().getY())/2;

        Line line = new Line(edge.getVertA().getX(),edge.getVertA().getY(),edge.getVertB().getX(),edge.getVertB().getY());

        Text massText = new Text(x-10, y-8, String.valueOf(edge.getMass()));
        massText.setFont(Font.font(16));

        ArrayList<Node> list = new ArrayList<>();
        list.add(line);
        list.add(massText);

        return list;
    }

    public ArrayList<Node> drawVert(VerticesGraphConstructor vert){

        ArrayList<Node> list = new ArrayList<>();

        list.add(drawCirVert(vert));
        list.add(drawCirVertIn(vert));
        list.add(drawTextVert(vert));

        return list;

    }

    /** Создание внейшней окружности */
    private Circle drawCirVert(VerticesGraphConstructor vert){
        Circle circleVert = new Circle(vert.getX(),vert.getY(),vert.getRadius());
        circleVert.setFill(Color.BLACK);
        return circleVert;
    }

    /** Создание внутренней окружности */
    private Circle drawCirVertIn(VerticesGraphConstructor vert){
        Circle circleVertIn = new Circle(vert.getX(),vert.getY(),vert.getRadius() - 2);
        circleVertIn.setFill(vert.getBGcolor());
        return circleVertIn;
    }

    /** Создание текста нумерации вершины */
    private Text drawTextVert(VerticesGraphConstructor vert){
        Text textVert = new Text(vert.getX()-6,vert.getY()+6,String.valueOf(vert.getNumber()));
        textVert.setFill(Color.BLACK);
        textVert.setFont(Font.font(vert.getRadius()));
        return textVert;
    }

}
