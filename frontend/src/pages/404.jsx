import NextLink from "next/link";
import {Box, Heading, Text, Button} from '@chakra-ui/react';
import {NextSeo} from "next-seo";
import Header from "../components/header";

const Custom404 = () => (
    <>
        <NextSeo title="404 Page Not Found"/>


        <Header/>
        <Box as="section"
             display="flex"
             flexDir="column"
             //cener all content
             justifyContent="center"
             alignItems="center"
             height="90vh">



            <>
                <Heading
                    display="inline-block"
                    as="h2"
                    size="4xl"
                    bgGradient="linear(to-r, teal.400, teal.600)"
                    backgroundClip="text">
                    404
                </Heading>
                <Text fontSize="18px" mt={3} mb={2}>
                    Page Not Found
                </Text>
                <Text color={'gray.500'} p={4} mb={6} align={"center"}>
                    The page you&apos;re looking for does not seem to exist
                </Text>

                <Button size="lg">
                    <NextLink href="/">
                        <a>Back to home page</a>
                    </NextLink>
                </Button>
            </>

        </Box>
    </>
);

export default Custom404;
