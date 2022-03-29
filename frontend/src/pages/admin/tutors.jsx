import React, {useEffect} from "react";
import {
    useToast,
    Center,
    VStack,
    Heading,
    Wrap,
    WrapItem,
    chakra,
    InputGroup,
    Input,
    InputRightElement,
    ButtonGroup,
    Button,
    IconButton,
    Divider,
    Drawer,
    DrawerOverlay,
    DrawerContent,
    DrawerCloseButton,
    DrawerHeader,
    DrawerBody,
    Stack,
    Box,
    FormControl, FormLabel, FormErrorMessage, DrawerFooter, SimpleGrid, useDisclosure,
} from "@chakra-ui/react";
import Layout from "../../components/layout";
import {userService} from "../../services";
import TableTutors from "../../components/tableTutors";
    ;
import {BsFillEraserFill} from "react-icons/bs";
import {AddIcon} from "@chakra-ui/icons";
import {useForm} from "react-hook-form";

export default function Tutors() {
    const toast = useToast();
    const [tutors, setTutors] = React.useState([]);
    const {isOpen, onOpen, onClose} = useDisclosure()
    const firstField = React.useRef()


    function fectTutors() {
        userService.getTutors().then(res => {
            setTutors(res)
        })
    }

    useEffect(() => {
        fectTutors()
    }, [])

    //Create new student student
    const {
        handleSubmit,
        register,
        setValue,
        formState: {errors, isSubmitting}
    } = useForm();
    //Search student by identifycation
    const {
        handleSubmit: handleSubmitSearch,
        register: registerSearch,
        setValue: setValueSearch,
        formState: {errors: errorsSearch, isSubmitting: isSubmittingSearch}
    } = useForm();

    function onSubmit(values) {
        const newstudent = {
            year: values.year,
            startDate: values.startDate,
            endDate: values.endDate,
            index: values.index,
        };

    }

    function onSubmitSearch(values) {

    }

    function clearFilter() {
        fectTutors();
        setValueSearch("yearSearch", "");
    }

    return (
        <>
            <>
                <VStack
                    align="left"
                    justify="left"
                    w="100%"
                    h="100%"
                >
                    <Heading
                        as="h1"
                        size="xl"
                        fontWeight="bold"
                        textAlign="left"
                    >
                        Tutors
                    </Heading>
                    <Wrap
                        justify="end"
                        spacing={4}
                        pb={4}
                    >
                        {
                            /*
                            <WrapItem>
                            <chakra.form
                                onSubmit={handleSubmitSearch(onSubmitSearch)}
                            >
                                <InputGroup size='md' w={'180px'}>
                                    <Input
                                        isInvalid={errorsSearch.yearSearch}
                                        id="idSearch"
                                        type="number"
                                        maxLength={4}
                                        pr='4.5rem'
                                        placeholder="Year"
                                        {...registerSearch("idSearch", {
                                            required: "Year is required",
                                            valueAsNumber: true,
                                            pattern: {
                                                value: /^[0-9]*$/,
                                                message: "Year must be a number"
                                            },
                                            minLength: {
                                                value: 4,
                                                message: "Year must be 4 digits"
                                            },
                                            maxLength: {
                                                value: 4,
                                                message: "Year must be 4 digits"
                                            },
                                            max: {
                                                value: 9999,
                                                message: "Year must be less than 9999"
                                            },
                                            min: {
                                                value: 1900,
                                                message: "Year must be greater than 1900"
                                            }

                                        })}
                                    />
                                    <InputRightElement
                                        width='7rem'
                                        z-index='1'
                                    >
                                        <ButtonGroup size='sm' isAttached>
                                            <Button
                                                h='1.75rem'
                                                size='sm'
                                                type='submit'
                                                isLoading={isSubmittingSearch}>
                                                <span>Search</span>
                                            </Button>
                                            <IconButton
                                                h='1.75rem'
                                                size='sm'
                                                aria-label='clean'
                                                onClick={clearFilter}
                                                icon={<BsFillEraserFill/>}/>
                                        </ButtonGroup>

                                    </InputRightElement>
                                </InputGroup>
                            </chakra.form>
                        </WrapItem>

                        <Divider orientation='vertical' variant='dashed'
                        />
                            * */


                        }

                        <WrapItem>
                            <Button
                                leftIcon={<AddIcon/>}
                                colorScheme="blue"
                                onClick={onOpen}
                            >
                                Add Tutor
                            </Button>
                            <Drawer
                                isOpen={isOpen}
                                placement='right'
                                initialFocusRef={firstField}
                                onClose={onClose}
                            >
                                <DrawerOverlay/>
                                <chakra.form
                                    onSubmit={handleSubmit(onSubmit)}
                                >
                                    <DrawerContent>
                                        <DrawerCloseButton/>
                                        <DrawerHeader borderBottomWidth='1px'>
                                            Create a new account
                                        </DrawerHeader>

                                        <DrawerBody>
                                            <Stack spacing='24px'>

                                                <Box>
                                                    <FormControl isRequired isInvalid={errors.year}>
                                                        <FormLabel htmlFor="year">Year</FormLabel>
                                                        <Input
                                                            type="number"
                                                            id="year"
                                                            {...register('year', {
                                                                required: 'Year is required',
                                                                minLength: {
                                                                    value: 4,
                                                                    message: 'Year must be at least 4 characters'
                                                                },
                                                                maxLength: {
                                                                    value: 4,
                                                                    message: 'Year must be at most 4 characters'
                                                                },
                                                                pattern: {
                                                                    value: /^[0-9]+$/,
                                                                    message: 'Year must be a number'
                                                                }
                                                            })}
                                                        />
                                                        <FormErrorMessage>
                                                            {errors.year && errors.year.message}
                                                        </FormErrorMessage>
                                                    </FormControl>

                                                </Box>
                                                <Box>
                                                    <FormControl isRequired isInvalid={errors.index}>
                                                        <FormLabel htmlFor="index">Number</FormLabel>
                                                        <Input
                                                            type="number"
                                                            id="index"

                                                            {...register('index', {
                                                                required: 'Index is required',
                                                                minLength: {
                                                                    value: 1,
                                                                    message: 'Index must be at least 1 characters'
                                                                },
                                                                maxLength: {
                                                                    value: 1,
                                                                    message: 'Index must be at most 1 characters'
                                                                },
                                                                pattern: {
                                                                    value: /^[0-9]+$/,
                                                                    message: 'Index must be a number'
                                                                }
                                                            })}
                                                        />
                                                        <FormErrorMessage>
                                                            {errors.index && errors.index.message}
                                                        </FormErrorMessage>
                                                    </FormControl>
                                                </Box>

                                                <Box>
                                                    <FormControl isRequired isInvalid={errors.startDate}>
                                                        <FormLabel htmlFor="date">Start Date</FormLabel>
                                                        <Input
                                                            type="date"
                                                            id="startDate"
                                                            {...register('startDate', {
                                                                required: 'Start Date is required',
                                                            })}
                                                        />
                                                        <FormErrorMessage>
                                                            {errors.startDate && errors.startDate.message}
                                                        </FormErrorMessage>
                                                    </FormControl>
                                                </Box>
                                                <Box>
                                                    <FormControl isRequired isInvalid={errors.endDate}>
                                                        <FormLabel htmlFor="date">End Date</FormLabel>
                                                        <Input
                                                            type="date"
                                                            id="endDate"
                                                            {...register('endDate', {
                                                                required: 'End Date is required',
                                                            })}
                                                        />
                                                        <FormErrorMessage>
                                                            {errors.endDate && errors.endDate.message}
                                                        </FormErrorMessage>
                                                    </FormControl>
                                                </Box>


                                            </Stack>
                                        </DrawerBody>

                                        <DrawerFooter borderTopWidth='1px'>
                                            <Button variant='outline' mr={3} onClick={onClose}>
                                                Cancel
                                            </Button>
                                            <Button
                                                type="submit"
                                                isLoading={isSubmitting}
                                                colorScheme='blue'>Submit</Button>
                                        </DrawerFooter>
                                    </DrawerContent>
                                </chakra.form>
                            </Drawer>
                        </WrapItem>

                    </Wrap>

                    <TableTutors
                        tutors={tutors}
                    />
                </VStack>
            </>

        </>
    );
}
Tutors.layout = Layout;

