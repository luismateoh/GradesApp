import React from 'react';
import {
    Box,
    useColorModeValue,
    Drawer,
    DrawerContent,
    useDisclosure,

} from '@chakra-ui/react';
import SidebarContent from "./sidebarContent";
import MobileNav from "./mobileNav";
import AdminIndex from "../../pages/admin";


export default function Layout({children}) {
    const {isOpen, onOpen, onClose} = useDisclosure();

    return (<Box minH="100vh" bg={useColorModeValue('gray.100', 'gray.900')}>
        <SidebarContent
            onClose={() => onClose}
            display={{base: 'none', md: 'block'}}
        />
        <Drawer
            autoFocus={false}
            isOpen={isOpen}
            placement="left"
            onClose={onClose}
            returnFocusOnClose={false}
            onOverlayClick={onClose}
            size="full">
            <DrawerContent>
                <SidebarContent onClose={onClose}/>
            </DrawerContent>
        </Drawer>
        {/* mobilenav */}
        <MobileNav onOpen={onOpen}/>
        <Box ml={{base: 2, md: 60}} p="4">
            {children}
        </Box>
    </Box>);
}
AdminIndex.Layout = Layout;
