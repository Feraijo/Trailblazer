package model;

/**
 * Created by Feraijo on 06.10.2016.
 */
public abstract class CollisionObject extends GameObject
{
    public CollisionObject(int x, int y)
    {
        super(x, y);
    }

    /*
Этот метод должен возвращаться true, если при перемещении текущего
объекта в направлении direction на FIELD_SELL_SIZE произойдет
столкновение с объектом gameObject, переданным в качестве параметра.
Иначе – возвращать false. Столкновением считать совпадение координат x и y.
     */
    public boolean isCollision(GameObject gameObject, Direction direction){
        boolean result = false;
        switch (direction)
        {
            case W:
                if (getX() - Model.FIELD_SELL_SIZE == gameObject.getX() && getY() == gameObject.getY())
                    result = true;
                break;
            case E:
                if (getX() + Model.FIELD_SELL_SIZE == gameObject.getX() && getY() == gameObject.getY())
                    result = true;
                break;
            case N:
                if (getX() == gameObject.getX() && getY() - Model.FIELD_SELL_SIZE == gameObject.getY())
                    result = true;
                break;
            case S:
                if (getX() == gameObject.getX() && getY() + Model.FIELD_SELL_SIZE == gameObject.getY())
                    result = true;
                break;
        }
        return result;
    }
}
