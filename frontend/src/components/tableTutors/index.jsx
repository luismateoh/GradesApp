// Chakra imports
import {
    Box,
    Table,
    Tbody,
    Td,
    Tfoot,
    Th,
    Thead,
    Tr,
    Text,
    VStack,
    Button,
    useColorModeValue
} from "@chakra-ui/react";
// Custom components
import Pagination from "./pagination";

export default function TableTutors({tutors}) {


    return (

        <Box maxW='full' borderWidth='1px' borderRadius='lg' overflow='hidden' justifyContent={'center'}
             bg={useColorModeValue("white", "gray.800")}
             p={4}
        >
            <Table size={'sm'} variant='simple'>
                <Thead
                    pt={6}
                >
                    <Tr>
                        <Th>Tutor</Th>
                        <Th>Email</Th>
                        <Th></Th>
                    </Tr>
                </Thead>
                <Tbody>
                    {tutors.map((student, index) => (

                        <Tr key={index}>
                            <Td><VStack
                                alignItems={'initial'}
                            >
                                <Text>{student.names} {student.lastNames}</Text>
                                <Text>{student.identityNumber}</Text>
                            </VStack></Td>
                            <Td>{student.email}</Td>
                            <Td alignItems={'initial'}>
                                <Button variantColor='blue' size='sm'
                                        onClick={() => {
                                            console.log(student.id)
                                        }}>
                                    <Text fontSize='sm'>Edit</Text>
                                </Button>
                            </Td>
                        </Tr>
                    ))}
                </Tbody>
                {
                    tutors.length > 25 &&
                    <Tfoot>
                        <Tr>
                            <Td colSpan={4}>
                                <Pagination/>
                            </Td>
                        </Tr>
                    </Tfoot>
                }
            </Table>
        </Box>

    );
}
