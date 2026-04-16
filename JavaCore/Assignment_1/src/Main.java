import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Department[] departments = new Department[3];
        departments[0] = new Department("Sale");
        departments[1] = new Department("Marketing");
        departments[2] = new Department("Sale");
        Position[] positions = new Position[3];
        positions[0] = new Position(PositionName.SCRUM_MASTER);
        positions[0] = new Position(PositionName.DEV);
        positions[0] = new Position(PositionName.PM);
        Account[] accounts = new Account[3];
        accounts[0] = new Account("user1@gmail.com","user1","Nguyen van A",departments[0],positions[0], LocalDate.now());
        accounts[1] = new Account("user2@gmail.com","user2","Nguyen van B",departments[1],positions[1], LocalDate.now());
        accounts[2] = new Account("user3@gmail.com","user3","Nguyen van C",departments[2],positions[2], LocalDate.now());
        Group[] groups = new Group[3];
        groups[0] = new Group("group1",accounts[0],LocalDate.now());
        groups[1] = new Group("group2",accounts[1],LocalDate.now());
        groups[2] = new Group("group3",accounts[2],LocalDate.now());
        GroupAccount[] groupAccounts = new GroupAccount[3];
        groupAccounts[0] = new GroupAccount(groups[0],accounts[0],LocalDate.now());
        groupAccounts[1] = new GroupAccount(groups[1],accounts[1],LocalDate.now());
        groupAccounts[2] = new GroupAccount(groups[2],accounts[2],LocalDate.now());
        TypeQuestion[] typeQuestions = new TypeQuestion[3];
        typeQuestions[0] = new TypeQuestion(TypeName.ESSAY);
        typeQuestions[1] = new TypeQuestion(TypeName.ESSAY);
        typeQuestions[2] = new TypeQuestion(TypeName.MULTIPLE_CHOICE);
        CategoryQuestion[] categoryQuestions = new CategoryQuestion[3];
        categoryQuestions[0]= new CategoryQuestion("Java");
        categoryQuestions[1]= new CategoryQuestion("SQL");
        categoryQuestions[2]= new CategoryQuestion("Postman");
        Question[] questions = new Question[3];
        questions[0] = new Question("content1",categoryQuestions[0],typeQuestions[0],accounts[0],LocalDate.now());
        questions[1] = new Question("content2",categoryQuestions[1],typeQuestions[1],accounts[1],LocalDate.now());
        questions[2] = new Question("content3",categoryQuestions[2],typeQuestions[2],accounts[2],LocalDate.now());
        Answer[] answers = new Answer[3];
        answers[0] = new Answer("answer1",questions[0],true);
        answers[1] = new Answer("answer2",questions[1],true);
        answers[2] = new Answer("answer3",questions[2],false);
        Exam[] exams = new Exam[3];
        exams[0] = new Exam("code1","title1",categoryQuestions[0],30,accounts[0],LocalDate.now());
        exams[1] = new Exam("code2","title2",categoryQuestions[1],45,accounts[1],LocalDate.now());
        exams[2] = new Exam("code3","title3",categoryQuestions[2],60,accounts[2],LocalDate.now());
        ExamQuestion[] examQuestions = new ExamQuestion[3];
        examQuestions[0] = new ExamQuestion(exams[0],questions[0]);
        examQuestions[1] = new ExamQuestion(exams[1],questions[1]);
        examQuestions[2] = new ExamQuestion(exams[2],questions[2]);
        System.out.println(departments[0]);
        System.out.println(positions[0]);
        System.out.println(accounts[0]);
        System.out.println(groups[0]);
        System.out.println(groupAccounts[0]);
        System.out.println(typeQuestions[0]);
        System.out.println(categoryQuestions[0]);
        System.out.println(questions[0]);
        System.out.println(answers[0]);
        System.out.println(exams[0]);
        System.out.println(examQuestions[0]);
    }
}