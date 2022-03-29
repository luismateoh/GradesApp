import {Box, use, useColorModeValue} from "@chakra-ui/react";

import Logo from "../logo";
import Navbar from "./navbar";

const Header = () => (
    <Box
        as="header"
        fontSize="18px"
        shadow="md"
        position="sticky"
        top="0"
        zIndex="1"
        bg={useColorModeValue("white", "gray.800")}

    >
        <Box
            display="flex"
            justifyContent="space-between"
            alignItems="center"
            px={[4, 6, 10, 14, 20]}
            maxW="1300px"
            mx="auto"
            h="4rem"
            p
        >
            <Logo/>
            <Navbar/>
        </Box>
    </Box>
);

export default Header;
