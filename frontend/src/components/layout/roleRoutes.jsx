import {
    FaUniversity,
    FaUserGraduate,
    FaUserTie,
    FaBook
} from "react-icons/fa";
import {
    BsFillCalendar3RangeFill,
    BsFillJournalBookmarkFill,
} from "react-icons/bs";

export function RoleRoutes(role) {
    if (role === "ADMIN") {
        return [
            {name: 'Institution', icon: FaUniversity, linkPage: "/admin/institution"},
            {name: 'Periods', icon: BsFillCalendar3RangeFill, linkPage: "/admin/periods"},
            {name: 'Tutors', icon: FaUserTie, linkPage: "/admin/tutors"},
            {name: 'Students', icon: FaUserGraduate, linkPage: "/admin/students"},
            {name: 'Subjects', icon: FaBook, linkPage: "/admin/subjects"},

        ];
    } else if (role === "TUTOR") {

        return [
            {name: 'Subjects', icon: FaBook, linkPage: "/tutor/subjects"},
        ];


    } else if (role === "STUDENT") {

        return [
            {name: 'Grades', icon: FaBook, linkPage: "/student/grades"},

        ];
    }
}




