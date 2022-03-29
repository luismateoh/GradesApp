import React from "react";
import {
    chakra,
    Box,
    useColorModeValue,
    Button,
    Stack,
    Image,
    Text,
    Icon,
} from "@chakra-ui/react";

export default function Hero() {
    return (
        <Box px={8} py={24} mx="auto">
            <Box
                w={{ base: "full", md: 11 / 12, xl: 9 / 12 }}
                mx="auto"
                textAlign={{ base: "left", md: "center" }}
            >
                <chakra.h1
                    mb={6}
                    fontSize={{ base: "4xl", md: "6xl" }}
                    fontWeight="bold"
                    lineHeight="none"
                    letterSpacing={{ base: "normal", md: "tight" }}
                    color={useColorModeValue("gray.900", "gray.100")}
                >
                    All your{" "}
                    <Text
                        display={{ base: "block", lg: "inline" }}
                        w="full"
                        bgClip="text"
                        bgGradient="linear(to-r, green.400,purple.500)"
                        fontWeight="extrabold"
                    >
                        GRADES
                    </Text>{" "}
                    in one single place.
                </chakra.h1>
                <chakra.p
                    px={{ base: 0, lg: 24 }}
                    mb={6}
                    fontSize={{ base: "lg", md: "xl" }}
                    color={useColorModeValue("gray.600", "gray.300")}
                >
                    Grades is a web application that allows you to track your
                    grades and maintain your academic record.
                </chakra.p>
            </Box>
            <Box
                w={{ base: "full", md: 10 / 12 }}
                mx="auto"
                mt={20}
                textAlign="center"
            >
                <Image
                    w="full"
                    rounded="lg"
                    shadow="2xl"
                    src="https://kutty.netlify.app/hero.jpg"
                    alt="Hellonext feedback boards software screenshot"
                />
            </Box>
        </Box>
    );
};

