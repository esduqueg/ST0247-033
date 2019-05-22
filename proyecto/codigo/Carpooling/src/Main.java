
public class Main {

    public static void main (String[]args){

        DataObtainer db = new DataObtainer();
        //db.Read("C://Users//pedro//Documents//dataset-ejemplo-U=11-p=1.1.txt");
        //db.Read("C://Users//pedro//Documents//dataset-ejemplo-U=205-p=1.1.txt");

        String[] paths = {"C://Users//pedro//Documents//dataset-ejemplo-U=11-p=1.1.txt",
                "C://Users//pedro//Documents//dataset-ejemplo-U=11-p=1.2.txt",
                "C://Users//pedro//Documents//dataset-ejemplo-U=11-p=1.3.txt",
                "C://Users//pedro//Documents//dataset-ejemplo-U=205-p=1.1.txt",
                "C://Users//pedro//Documents//dataset-ejemplo-U=205-p=1.2.txt",
                "C://Users//pedro//Documents//dataset-ejemplo-U=205-p=1.3.txt",
        };

        for(int i = 0; i<paths.length;++i){

            db.Read(paths[i]);

        }

    }

}
