import java.util.*;

public class ProgramApp {
    public static void main(String[] args) {
        String programCode, programDescription, duration, faculty, programHead;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter program code (e.g. CS110): ");
        programCode = input.nextLine();

        System.out.print("Enter program description: (e.g Diploma in Computer Science): ");
        programDescription = input.nextLine();

        System.out.print("Enter duration (e.g. 3 years): ");
        duration = input.nextLine();

        System.out.print("Enter faculty (e.g. FSKM): ");
        faculty = input.nextLine();

        System.out.print("Enter program head: ");
        programHead = input.nextLine();

        Program program = new Program(programCode, programDescription, duration, faculty, programHead);

        System.out.println(program);

        input.close();
    }
}
