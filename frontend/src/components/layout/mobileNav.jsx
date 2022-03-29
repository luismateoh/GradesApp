import {
    Avatar, Box,
    chakra,
    Flex,
    HStack,
    IconButton,
    Img,
    Menu,
    MenuButton, MenuDivider, MenuGroup, MenuItem, MenuList, Text,
    useColorMode,
    useColorModeValue, VStack
} from "@chakra-ui/react";
import React, {useEffect, useState} from "react";
import {FiChevronDown, FiMenu} from "react-icons/fi";
import DarkModeToggle from "../darkModeToggle";
import {userService} from "../../services";

export default function MobileNav({onOpen, ...rest}) {
    function logout() {
        userService.logout();
    }

    const {colorMode, toggleColorMode} = useColorMode();
    const [user, setUser] = useState({'names': '', 'email': '', 'role': ''});
    const [avatar, setAvatar] = useState('');
    useEffect(() => {
        userService.getUserInfo().then(x => {
            setUser(x);
            setAvatar('https://avatars.dicebear.com/api/identicon/' + x.names + '.svg');
        });
    }, []);

    return (<Flex
        ml={{base: 0, md: 60}}
        px={{base: 4, md: 4}}
        height="20"
        //sticky
        position="sticky"
        top="0"
        zIndex="1"

        //shadow in bottom
        shadow="md"
        alignItems="center"
        bg={useColorModeValue('white', 'gray.900')}
        borderBottomWidth="1px"
        borderBottomColor={useColorModeValue('gray.200', 'gray.700')}
        justifyContent={{base: 'space-between', md: 'flex-end'}}
        {...rest}>
        <IconButton
            display={{base: 'flex', md: 'none'}}
            onClick={onOpen}
            variant="outline"
            aria-label="open menu"
            icon={<FiMenu/>}
        />


        <HStack spacing={2}
                display={{base: 'flex', md: 'none'}}
        >
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

        <HStack spacing={{base: '6', md: '6'}}>
            <DarkModeToggle onClick={toggleColorMode} colorMode={colorMode}/>
            <Flex alignItems={'center'}>
                <Menu isLazy>
                    <MenuButton
                        py={2}
                        transition="all 0.3s"
                        _focus={{boxShadow: 'none'}}>

                        <HStack>
                            <Avatar
                                h={9}
                                w={9}
                                //shape = square
                                borderRadius={'2'}
                                src={avatar}
                                alt="avatar"
                            />
                            <VStack
                                display={{base: 'none', md: 'flex'}}
                                alignItems="flex-start"
                                spacing="1px"
                                ml="2">
                                <Text fontSize="sm">{user.names}{" "}{user.lastNames}</Text>
                                <Text fontSize="xs" color="gray.600">
                                    {user.email}
                                </Text>
                            </VStack>
                            <Box display={{base: 'none', md: 'flex'}}>
                                <FiChevronDown/>
                            </Box>
                        </HStack>
                    </MenuButton>
                    <MenuList
                        bg={useColorModeValue('white', 'gray.900')}
                        borderColor={useColorModeValue('gray.200', 'gray.700')}>
                        <MenuGroup title={'Role'}/>
                        <Text pl={4}>{user.role.toLowerCase()}</Text>
                        <MenuDivider/>
                        <MenuItem onClick={logout}>Sign out</MenuItem>

                    </MenuList>
                </Menu>
            </Flex>
        </HStack>
    </Flex>);
};