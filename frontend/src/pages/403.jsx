import NextImage from "next/image";
import NextLink from "next/link";

import {Box, Button, Heading, Text} from "@chakra-ui/react";
import { NextSeo } from "next-seo";
import Header from "../components/header";

const Custom403 = () => (
  <>
    <NextSeo title="403 Unauthorized" />


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
                  403
              </Heading>
              <Text fontSize="18px" mt={3} mb={2}>
                  Forbidden
              </Text>
              <Text color={'gray.500'} p={4} mb={6} align={"center"}>
                  You don&apos;t have permission to access this page.
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

export default Custom403;
