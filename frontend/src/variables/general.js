// Assets
// Custom icons

import { AiOutlineExclamation } from "react-icons/ai";
import {
  FaArrowDown,
  FaArrowUp,
  FaBell,
  FaCreditCard,
  FaFilePdf,
  FaHtml5,
  FaShoppingCart,
} from "react-icons/fa";
import { SiDropbox } from "react-icons/si";


export const tablesTableData = [
  {
    logo: "avatar1",
    name: "Esthera Jackson",
    email: "alexa@simmmple.com",
    subdomain: "Manager",
    domain: "Organization",
    status: "Online",
    date: "14/06/21",
  },
  {
    logo: "avatar2",
    name: "Alexa Liras",
    email: "laurent@simmmple.com",
    subdomain: "Programmer",
    domain: "Developer",
    status: "Offline",
    date: "12/05/21",
  },
  {
    logo: "avatar3",
    name: "Laurent Michael",
    email: "laurent@simmmple.com",
    subdomain: "Executive",
    domain: "Projects",
    status: "Online",
    date: "07/06/21",
  },
  {
    logo: "avatar4",
    name: "Freduardo Hill",
    email: "freduardo@simmmple.com",
    subdomain: "Manager",
    domain: "Organization",
    status: "Online",
    date: "14/11/21",
  },
  {
    logo: "avatar5",
    name: "Daniel Thomas",
    email: "daniel@simmmple.com",
    subdomain: "Programmer",
    domain: "Developer",
    status: "Offline",
    date: "21/01/21",
  },
  {
    logo: "avatar7",
    name: "Mark Wilson",
    email: "mark@simmmple.com",
    subdomain: "Designer",
    domain: "UI/UX Design",
    status: "Offline",
    date: "04/09/20",
  },
];


export const invoicesData = [
  {
    date: "March, 01, 2020",
    code: "#MS-415646",
    price: "$180",
    logo: FaFilePdf,
    format: "PDF",
  },
  {
    date: "February, 10, 2020",
    code: "#RV-126749",
    price: "$250",
    logo: FaFilePdf,
    format: "PDF",
  },
  {
    date: "April, 05, 2020",
    code: "#FB-212562",
    price: "$560",
    logo: FaFilePdf,
    format: "PDF",
  },
  {
    date: "June, 25, 2019",
    code: "#QW-103578",
    price: "$120",
    logo: FaFilePdf,
    format: "PDF",
  },
  {
    date: "March, 01, 2019",
    code: "#AR-803481",
    price: "$300",
    logo: FaFilePdf,
    format: "PDF",
  },
];

export const billingData = [
  {
    name: "Oliver Liam",
    company: "Viking Burrito",
    email: "oliver@burrito.com",
    number: "FRB1235476",
  },
  {
    name: "Lucas Harper",
    company: "Stone Tech Zone",
    email: "lucas@stone-tech.com",
    number: "FRB1235476",
  },
  {
    name: "Ethan James",
    company: "Fiber Notion",
    email: "ethan@fiber.com",
    number: "FRB1235476",
  },
];

export const newestTransactions = [
  {
    name: "Netflix",
    date: "27 March 2022, at 12:30 PM",
    price: "- $2,500",
    logo: FaArrowDown,
  },
  {
    name: "Apple",
    date: "27 March 2022, at 12:30 PM",
    price: "+ $2,500",
    logo: FaArrowUp,
  },
];

export const olderTransactions = [
  {
    name: "Stripe",
    date: "26 March 2022, at 13:45 PM",
    price: "+ $800",
    logo: FaArrowUp,
  },
  {
    name: "HubSpot",
    date: "26 March 2022, at 12:30 PM",
    price: "+ $1,700",
    logo: FaArrowUp,
  },
  {
    name: "Webflow",
    date: "26 March 2022, at 05:00 PM",
    price: "Pending",
    logo: AiOutlineExclamation,
  },
  {
    name: "Microsoft",
    date: "25 March 2022, at 16:30 PM",
    price: "- $987",
    logo: FaArrowDown,
  },
];

export const pageVisits = [
  {
    pageName: "/argon/",
    visitors: "4,569",
    uniqueUsers: 340,
    bounceRate: "46,53%"
  },
  {
    pageName: "/argon/index.html",
    visitors: "3,985",
    uniqueUsers: 319,
    bounceRate: "46,53%"
  },
  {
    pageName: "/argon/charts.html",
    visitors: "3,513",
    uniqueUsers: 294,
    bounceRate: "36,49%"
  },
  {
    pageName: "/argon/tables.html",
    visitors: "2,050",
    uniqueUsers: 147,
    bounceRate: "50,87%"
  },
  {
    pageName: "/argon/profile.html",
    visitors: "1,795",
    uniqueUsers: 190,
    bounceRate: "46,53%"
  },
]

export const socialTraffic = [
  {
    referral: "Facebook",
    visitors: "1,480",
    percentage: 60,
    color: "orange",
  },
  {
    referral: "Facebook",
    visitors: "5,480",
    percentage: 70,
    color: "orange",
  },
  {
    referral: "Google",
    visitors: "4,807",
    percentage: 80,
    color: "cyan",
  },
  {
    referral: "Instagram",
    visitors: "3,678",
    percentage: 75,
    color: "cyan",
  },
  {
    referral: "Twitter",
    visitors: "2,645",
    percentage: 30,
    color: "orange",
  }
]
