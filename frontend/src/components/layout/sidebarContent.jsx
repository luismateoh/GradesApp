import {Box, chakra, CloseButton, Flex, HStack, Img, useColorModeValue} from "@chakra-ui/react";
import React, {useEffect, useState} from "react";
import {RoleRoutes} from "./roleRoutes";
import NavItem from "./navItem";
import {userService} from "../../services";


export default function SidebarContent({onClose, ...rest}) {
    const [linksItems, setLinksItems] = useState([{},]);
    const [user, setUser] = useState(userService.userValue);
    useEffect(() => {
        setLinksItems(RoleRoutes(user.role));
    }, [user.role]);

    return (
        <Box
            zIndex="2"
            bg={useColorModeValue('white', 'gray.900')}
            borderRight="1px"
            borderRightColor={useColorModeValue('gray.200', 'gray.700')}
            w={{base: 'full', md: 60}}
            pos="fixed"
            h="full"
            {...rest}>
            <Flex h="20" alignItems="center" mx="8" justifyContent="space-between">
                <HStack spacing={2}>
                    <Img
                        h={"2rem"}
                        src={`/icons/sun.svg`}
                        alt="Sun"
                        maxW="2rem"
                        maxH="2rem"
                    />
                    <chakra.a userSelect="none" fontSize="2rem" fontWeight="700">
                        Grades
                    </chakra.a>
                </HStack>
                <CloseButton display={{base: 'flex', md: 'none'}} onClick={onClose}/>
            </Flex>
            {linksItems?.map((link) => (<NavItem
                key={link.index}
                icon={link.icon} linkPage={link.linkPage}>
                {link.name}
            </NavItem>))}
        </Box>);
};