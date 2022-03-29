import {Box, Flex, chakra, Link, useColorModeValue, HStack, Button} from "@chakra-ui/react";
import {AiFillEdit, AiFillDelete} from "react-icons/ai";

export default function PeriodCard({period}) {
    return (

            <Box
                w="35vh"
                maxW="sm"
                px={4}
                py={3}
                bg={useColorModeValue("white", "gray.800")}
                shadow="md"
                rounded="md"
            >
                <Flex justifyContent="space-between" alignItems="center">
                    <chakra.span
                        fontSize="xl"
                        color={useColorModeValue("gray.800", "gray.400")}
                    >
                        N°{period.id}
                    </chakra.span>
                    <chakra.span
                        bg={useColorModeValue("blue.200", "blue.300")}
                        color={useColorModeValue("blue.800", "blue.900")}
                        px={3}
                        py={1}
                        rounded="full"
                        textTransform="uppercase"
                        fontSize="xs"
                        fontWeight="semibold"
                    >
                        {period.status}
                    </chakra.span>
                </Flex>

                <Box>
                    <chakra.h1
                        fontSize="lg"
                        fontWeight="bold"
                        mt={2}
                        color={useColorModeValue("gray.800", "white")}
                    >
                        {period.year} - {period.index}
                    </chakra.h1>
                </Box>

                <Box>
                    <HStack
                        alignItems="center"
                        mt={2}
                        color={useColorModeValue("gray.700", "gray.200")}
                    >
                        <span>From </span>
                        <span>{period.startDate}</span>

                    </HStack>
                    <HStack
                        alignItems="center"
                        color={useColorModeValue("gray.700", "gray.200")}
                    >
                        <span>To </span>
                        <span>{period.endDate}</span>

                    </HStack>


                    <Flex alignItems="end" justifyContent="end" mt={4}>
                        <Button
                            size="sm"
                            mr={1}
                            color={useColorModeValue("gray.800", "gray.400")}
                            _hover={{ color: useColorModeValue("gray.700", "gray.300") }}
                            cursor="pointer"
                        >
                            <AiFillEdit />
                        </Button>

                        <Button
                            size="sm"
                            color={useColorModeValue("gray.800", "gray.400")}
                            _hover={{ color: useColorModeValue("gray.700", "gray.300") }}
                            cursor="pointer"
                        >
                            <AiFillDelete />
                        </Button>
                    </Flex>
                </Box>
            </Box>
    );
};

