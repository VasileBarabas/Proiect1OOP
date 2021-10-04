import java.util.Arrays;

public class GradebookClass {
    private String _fullNameStudent;
    private String _specsStudent;
    private String _CNP;
    private String _passwordGrbk;
    private int _numberOfClasses;
    private String[] _nameOfClasses = new String[_numberOfClasses];
    private int[] _numberOfGrades = new int[_numberOfClasses];
    private int[][] _classGrades = new int[10][10];

    public GradebookClass(String _fullNameStudent, String _specsStudent, String _CNP, String _passwordGrbk, int _numberOfClasses, String[] _nameOfClasses, int[] _numberOfGrades) {
        this._fullNameStudent = _fullNameStudent;
        this._specsStudent = _specsStudent;
        this._CNP = _CNP;
        this._passwordGrbk = _passwordGrbk;
        this._numberOfClasses = _numberOfClasses;
        this._nameOfClasses = _nameOfClasses;
        this._numberOfGrades = _numberOfGrades;
    }

    public void afisareMaterii() {
        for (int i = 0; i < _numberOfClasses; ++i) {
            System.out.println(i + ". " + this._nameOfClasses[i]);
        }
    }

    public String toString() {
        return "GradebookClass{" +
                "_fullNameStudent='" + _fullNameStudent + '\'' +
                ", _specsStudent='" + _specsStudent + '\'' +
                ", _CNP='" + _CNP + '\'' +
                ", _passwordGrbk='" + _passwordGrbk + '\'' +
                ", _numberOfClasses=" + _numberOfClasses +
                ", _nameOfClasses=" + Arrays.toString(_nameOfClasses) +
                ", _numberOfGrades=" + Arrays.toString(_numberOfGrades) +
                '}';
    }

    public String get_CNP() {
        return _CNP;
    }

    public int numberOfGrades(int i) {
        return _numberOfGrades[i];
    }

    public int get_grade(int line, int column) {
        return _classGrades[line][column];
    }

    public int[][] get_classGrades() {
        return _classGrades;
    }

    public void set_classGrades(int[][] _classGrades) {
        this._classGrades = _classGrades;
    }

    public void afis() {
        for (int i = 0; i < _numberOfClasses; ++i) {
            for (int j = 0; j < _numberOfGrades[i]; ++j) {
                System.out.print(_classGrades[i][j] + " ");
            }
            System.out.println();
        }
    }
}
