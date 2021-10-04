import org.jetbrains.annotations.NotNull;

public class StudentClass {
    private String _fullNameStudent;
    private String _specsStudent;
    private String _CNP;
    private String _passwordGrbk;

    public StudentClass(String fullName, String specs, String CNP, String password) {
        this._fullNameStudent = fullName;
        this._specsStudent = specs;
        if (isNumber(CNP)) {
            this._CNP = CNP;
        } else {
            this._CNP = "0";
        }
        this._passwordGrbk = password;
    }

    public boolean isNumber(String str) {
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8' && c != '9')
                return false;
        }
        return true;
    }

    public String toString() {
        return "StudentClass{" +
                "_fullNameStudent='" + _fullNameStudent + '\'' +
                ", _specsStudent='" + _specsStudent + '\'' +
                ", _CNP='" + _CNP + '\'' +
                ", _passwordGrbk='" + _passwordGrbk + '\'' +
                '}';
    }
    public void set_CNP(String CNP)
    {
        if(isNumber(CNP))
        {
            this._CNP=CNP;
        }
    }
    public String get_CNP()
    {
        return _CNP;
    }
}
