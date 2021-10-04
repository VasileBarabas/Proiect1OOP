import java.util.Arrays;

public class CatalogClass {
        private GradebookClass[] _gradebooksClass=new GradebookClass[30];
        private int _numberOfStudent;
        public GradebookClass studentSearch(String CNP){
                for(int i=0;i<_numberOfStudent;++i) {
                        if (_gradebooksClass[i].get_CNP().equals(CNP)) {
                                return _gradebooksClass[i];
                        }
                }
                return null;
        }

        public int get_numberOfStudent() {
                return _numberOfStudent;
        }
        public void set_numberOfStudent(int _numberOfStudent) {
                this._numberOfStudent = _numberOfStudent;
        }

        public GradebookClass get_gradebooksClass(int i) {
                return _gradebooksClass[i];
        }

        public void set_gradebooksClass(GradebookClass _gradebooksClass, int i) {
                this._gradebooksClass[i] = _gradebooksClass;
        }

        public String toString() {
                return "CatalogClass{" +
                        "_gradebooksClass=" + Arrays.toString(_gradebooksClass) +
                        '}';
        }
}
