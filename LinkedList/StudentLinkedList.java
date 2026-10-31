
class Student {
    int studentId;
    String name;
    String department;
    int semester;
    double cgpa;

    Student(int studentId, String name, String department, int semester, double cgpa) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.semester = semester;
        this.cgpa = cgpa;
    }

    public void display() {
        System.out.println("Student ID: " + studentId +
                "\nName: " + name +
                "\nDepartment: " + department +
                "\nCGPA: " + cgpa +
                "\nSemester: " + semester +
                "\n--------------------------");
    }
}

class Node {
    Student data;
    Node next;

    Node(Student data) {
        this.data = data;
        this.next = null;
    }
}

class StudentLinkedList {
    Node head;
    Node tail;

    StudentLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addStudentFront(Student s) {
        Node newNode = new Node(s);

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addStudentBack(Student s) {
        Node newNode = new Node(s);

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void deleteStudentFront() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        head = head.next;
    }

    public void deleteStudentBack() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node curr = head;

        while (curr.next != tail) {
            curr = curr.next;
        }

        curr.next = null;
        tail = curr;
    }

    public void searchStudent(int studentId) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node curr = head;

        while (curr != null) {
            if (curr.data.studentId == studentId) {
                curr.data.display();
                return;
            }

            curr = curr.next;
        }

        System.out.println("Student not found");
    }

    public void displayStudents() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node curr = head;

        while (curr != null) {
            curr.data.display();
            curr = curr.next;
        }
    }

    public void deleteStudent(int studentId) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data.studentId == studentId) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
            return;
        }

        Node curr = head;

        while (curr.next != null) {
            if (curr.next.data.studentId == studentId) {
                if (curr.next == tail) {
                    tail = curr;
                }

                curr.next = curr.next.next;
                return;
            }

            curr = curr.next;
        }

        System.out.println("Student not found");
    }

    public void addStudentAfter(int studentId, Node n) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node curr = head;

        while (curr != null) {
            if (curr.data.studentId == studentId) {
                n.next = curr.next;
                curr.next = n;

                if (curr == tail) {
                    tail = n;
                }

                return;
            }

            curr = curr.next;
        }

        System.out.println("Student ID not found");
    }

    public void addStudentBefore(int studentId, Node n) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data.studentId == studentId) {
            n.next = head;
            head = n;
            return;
        }

        Node curr = head;

        while (curr.next != null) {
            if (curr.next.data.studentId == studentId) {
                n.next = curr.next;
                curr.next = n;
                return;
            }

            curr = curr.next;
        }

        System.out.println("Student ID not found");
    }

    public void updateStudent(int studentId, String name,
            String department, int semester, double cgpa) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node curr = head;

        while (curr != null) {
            if (curr.data.studentId == studentId) {
                curr.data.name = name;
                curr.data.department = department;
                curr.data.semester = semester;
                curr.data.cgpa = cgpa;

                System.out.println("Student information updated");
                return;
            }

            curr = curr.next;
        }

        System.out.println("Student not found");
    }
}

class Main {
    public static void main(String args[]) {
        StudentLinkedList list = new StudentLinkedList();

        Student s1 = new Student(101, "Ahmed", "Computer Science", 3, 3.95);
        Student s2 = new Student(102, "Ali", "Computer Science", 4, 3.45);
        Student s3 = new Student(103, "Zara", "Computer Science", 5, 3.75);
        Student s4 = new Student(104, "Umar", "Computer Science", 6, 3.85);

        list.addStudentFront(s1);
        list.addStudentBack(s2);

        list.addStudentAfter(102, new Node(s4));
        list.addStudentBefore(104, new Node(s3));

        list.updateStudent(101, "Asia", "BBA", 5, 3.98);

        list.displayStudents();
    }
}
