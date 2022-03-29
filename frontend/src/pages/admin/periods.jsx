import React, {useEffect} from "react";
import {
    useToast,
    Center,
    SimpleGrid,
    VStack,
    Heading,
    Box,
    Button,
    Input,
    chakra,
    Wrap,
    WrapItem,
    InputRightElement,
    InputGroup,
    Divider,
    DrawerOverlay,
    DrawerContent,
    DrawerCloseButton,
    DrawerHeader,
    DrawerBody,
    Stack,
    FormLabel,
    DrawerFooter,
    Drawer,
    useDisclosure,
    FormControl,
    FormErrorMessage,
    IconButton,
    ButtonGroup,
} from "@chakra-ui/react";
import Layout from "../../components/layout";
import PeriodCard from "../../components/periodCard";
import {periodService} from "../../services";
import {BsFillEraserFill} from "react-icons/bs";

import {useForm} from "react-hook-form";
import {AddIcon} from "@chakra-ui/icons";


export default function Periods() {
    const toast = useToast();
    const [periods, setPeriods] = React.useState([]);
    const {isOpen, onOpen, onClose} = useDisclosure()
    const firstField = React.useRef()


    function fectPeriods() {
        periodService.getPeriods().then(res => {
            setPeriods(res)
        })
    }

    useEffect(() => {
        fectPeriods()
    }, [])

    //Create new period form
    const {
        handleSubmit, register, setValue, formState: {errors, isSubmitting}
    } = useForm();
    //Search period by year form
    const {
        handleSubmit: handleSubmitSearch,
        register: registerSearch,
        setValue: setValueSearch,
        formState: {errors: errorsSearch, isSubmitting: isSubmittingSearch}
    } = useForm();

    function onSubmit(values) {
        const newPeriod = {
            year: values.year, startDate: values.startDate, endDate: values.endDate, index: values.index,
        };
        periodService.createPeriod(newPeriod).then(response => {
            setPeriods([...periods, response]);
            onClose();
            toast({
                title: "Success",
                description: "Period created successfully",
                position: "top-right",
                status: "success",
                duration: 9000,
                isClosable: true,
            });
        }).catch(error => {
            for (const key in error) {
                toast({
                    title: "Error",
                    description: error[key],
                    position: "top-right",
                    status: "error",
                    duration: 9000,
                    isClosable: true,
                });
            }
        });
    }


    function onSubmitSearch(values) {
        periodService.getPeriodsbyYear(parseInt(values.yearSearch)).then(response => {
            setPeriods(response);
        }).catch(error => {
            toast({
                title: "Error",
                description: error,
                position: "top-right",
                status: "error",
                duration: 9000,
                isClosable: true,
            });
        });
    }

    function clearFilter() {
        fectPeriods();
        setValueSearch("yearSearch", "");
    }

    return (<>
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
                    Periods
                </Heading>
                <Wrap
                    justify="end"
                    spacing={4}
                    pb={4}
                    maxW="165vh"
                >
                    <WrapItem>
                        <chakra.form
                            onSubmit={handleSubmitSearch(onSubmitSearch)}
                        >
                            <InputGroup size='md' w={'180px'}>
                                <Input
                                    isInvalid={errorsSearch.yearSearch}
                                    id="yearSearch"
                                    type="number"
                                    maxLength={4}
                                    pr='4.5rem'
                                    placeholder="Year"
                                    {...registerSearch("yearSearch", {
                                        required: "Year is required", valueAsNumber: true, pattern: {
                                            value: /^[0-9]*$/, message: "Year must be a number"
                                        }, minLength: {
                                            value: 4, message: "Year must be 4 digits"
                                        }, maxLength: {
                                            value: 4, message: "Year must be 4 digits"
                                        }, max: {
                                            value: 9999, message: "Year must be less than 9999"
                                        }, min: {
                                            value: 1900, message: "Year must be greater than 1900"
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
                    <WrapItem>
                        <Button
                            leftIcon={<AddIcon/>}
                            colorScheme="blue"
                            onClick={onOpen}
                        >
                            Add Period
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
                                                            required: 'Year is required', minLength: {
                                                                value: 4,
                                                                message: 'Year must be at least 4 characters'
                                                            }, maxLength: {
                                                                value: 4,
                                                                message: 'Year must be at most 4 characters'
                                                            }, pattern: {
                                                                value: /^[0-9]+$/, message: 'Year must be a number'
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
                                                            required: 'Index is required', minLength: {
                                                                value: 1,
                                                                message: 'Index must be at least 1 characters'
                                                            }, maxLength: {
                                                                value: 1,
                                                                message: 'Index must be at most 1 characters'
                                                            }, pattern: {
                                                                value: /^[0-9]+$/, message: 'Index must be a number'
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

                <Center>
                    <SimpleGrid
                        minChildWidth="35vh"
                        spacing={4}
                        justifyContent="space-between"
                        maxW="100%"
                    >
                        {periods.map(period => (<PeriodCard
                            key={period.id}
                            period={period}
                        />))}
                    </SimpleGrid>
                </Center>
            </VStack>
        </>

    );
}

Periods.layout = Layout;

