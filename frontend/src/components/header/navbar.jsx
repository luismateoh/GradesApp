import {Box, Button, useColorMode} from "@chakra-ui/react";
import Router, {useRouter} from "next/router";
import DarkModeToggle from "../darkModeToggle";


export default function Navbar() {

    const router = useRouter();
    const {colorMode, toggleColorMode} = useColorMode();

    return (
        <Box
            as="nav"
            display="flex"
            alignItems="center"
            gap="0.5rem"
        >
            <DarkModeToggle onClick={toggleColorMode} colorMode={colorMode}/>
            {router.pathname !== "/login" && (
                <Button
                    fontSize="sm"
                    fontWeight="bold"
                    onClick={() => {
                        Router.push("/login").then(r => {
                            window.scrollTo(0, 0);
                        });
                    }}
                >
                    Sign in
                </Button>
            )}

        </Box>
    );
}

