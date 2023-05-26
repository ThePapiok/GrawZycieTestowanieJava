package pliki;

import java.util.List;

public class Board {
    private boolean[][] tablica;
    private boolean[][] tablicaPom;

    private int szerokosc;
    private int wysokosc;

    public Board(int x, int y, List <Wspolrzedne> lista) {
        tablica=new boolean[y][x];
        tablicaPom=new boolean[y][x];
        szerokosc=x;
        wysokosc=y;
        setMartwe(x,y);
        setZywe(lista);
    }

    public void setMartwe(int x,int y)
    {
        for(int i=0;i<y;i++)
        {
            for(int j=0;j<x;j++)
            {
                tablica[i][j]=false;
            }
        }
    }

    public void setZywe(List<Wspolrzedne> lista)
    {
        for(Wspolrzedne a:lista)
        {
            tablica[a.getY()][a.getX()]=true;
        }
    }
    public int count(int x,int y)
    {
        int ipocz,ikon;
        int jpocz,jkon;
        int ilosc=0;
        ipocz=Math.max(y-1,0);
        ikon=Math.min(y+1,wysokosc-1);
        jpocz=Math.max(x-1,0);
        jkon=Math.min(x+1,szerokosc-1);
        for(int i=ipocz;i<=ikon;i++)
        {
            for(int j=jpocz;j<=jkon;j++)
            {
                if(i!=y||j!=x)
                {
                    if(tablica[i][j]==true)
                    {
                        ilosc++;
                    }
                }
            }
        }
        return ilosc;
    }
    public void changeStan(int x,int y)
    {
        int ilosc=count(x,y);
        if(tablica[y][x]==true)
        {
            if(ilosc<2||ilosc>3)
            {
                tablicaPom[y][x]=false;
            }
            else
            {
                tablicaPom[y][x]=true;
            }

        }
        else
        {
            if(ilosc==3)
            {
                tablicaPom[y][x]=true;
            }
            else
            {
                tablicaPom[y][x]=false;
            }
        }
    }

    public void aktualizacja()
    {
        for(int i=0;i<wysokosc;i++)
        {
            for(int j=0;j<szerokosc;j++)
            {
                changeStan(j,i);
            }
        }
        tablica=tablicaPom;
    }

    public boolean getStan(int x,int y)
    {
        return tablica[y][x];
    }

}
