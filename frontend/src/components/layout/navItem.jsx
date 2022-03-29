import {Flex, Icon, Link, useColorModeValue} from "@chakra-ui/react";
import React, {useEffect, useState} from "react";
import {useRouter} from "next/router";

export default function NavItem({icon, linkPage, children, ...rest}) {
    const router = useRouter();

    function isActive() {
        if (router.pathname === linkPage) {
            return ['telegram.600','white'];
        } else {
            return 'transparent';
        }
    }

    return (
        <Link
            href={linkPage}
            style={{textDecoration: 'none'}}
            _focus={{boxShadow: 'none'}}>
            <Flex
                align="center"
                p="2"
                mx="2"
                borderRadius="lg"
                role="group"
                cursor="pointer"
                //font color
                color={isActive()[1]}
                bg={isActive()[0]}
                _hover={{
                    bg: useColorModeValue('gray.200', 'gray.700'),
                    color: useColorModeValue('black', 'white')
                    }}
                {...rest}>
                {icon && (<Icon
                    mr="4"
                    fontSize="16"
                    as={icon}
                />)}
                {children}
            </Flex>
        </Link>);
};
