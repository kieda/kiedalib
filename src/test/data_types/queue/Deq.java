//package test.data_types.queue;
//
//import com.kieda.data_structures.AbstractQueue;
//import com.kieda.util.error.InvalidInputException;
//import test.Testable;
////import test.data_types.queue.StepQueue;
//public class Deq extends Testable{
//    private int step_curr;
//    private boolean exit_flag = false;
//    public final static int EMPTY_CHECK   = 0;
//    public final static int GET_LAST_NODE = 1;
//    public final static int SET_HEAD_NODE = 2;
//    public final static int GET_DATA      = 3;
//    public final static int RETURN        = 4;
////    private StepQueue obj;
//    private Object data = null;
//    @Override
//    protected void step(int step_id) {
//        step_curr = step_id;
//        switch(step_curr){
//            case EMPTY_CHECK:
//                if(obj.isEmpty()) exit_flag = true;
//                break;
//            case GET_LAST_NODE:
//                Object e = obj.head();
//            case SET_HEAD_NODE:
//            case GET_DATA:
//            case RETURN:
//                exit_flag = true;
//        }
//    }
//    /**
//     * public T deq(){
//        if(!isEmpty()){
//            Node rem = head.next;//the last item
//            head.next = rem.next;//next item
//            T s = rem.data;
//            rem = null;//let GC do its work.
//            return s;
//        }
//        return null;//can't remove an element.
//    }
//     * @return 
//     */
//    @Override
//    public boolean exit() {
//        return exit_flag;
//    }
//    @Override
//    protected Object return_o() {
//        return data;
//    }
//    @Override
//    protected void input(Object args) {
//        try{
//        if(!(args instanceof AbstractQueue)){
//            throw new InvalidInputException("Input has to be of type StepQueue");
//        }} catch(Exception e){e.printStackTrace();};
//        obj = ((StepQueue)args);
//    }
//}
