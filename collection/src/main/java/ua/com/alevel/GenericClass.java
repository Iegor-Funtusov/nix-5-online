package ua.com.alevel;

public class GenericClass<T> {

    private Object res;
    private Object[] res1;
    private T[] resGen1;
    private T resGen;

    public Object getRes() {
        return res;
    }

    public void setRes(Object res) {
        this.res = res;
    }

    public T getResGen() {
        return resGen;
    }

    public void setResGen(T resGen) {
        this.resGen = resGen;
    }
}
