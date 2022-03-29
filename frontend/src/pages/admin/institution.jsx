import React from "react";
import {
    chakra,
    Box,
    useColorModeValue,
    SimpleGrid,
    GridItem,
    Heading,
    Text,
    Stack,
    FormControl,
    FormLabel,
    Input,
    Button,
    useToast,
    Center,
    Textarea,
    FormErrorMessage,
} from "@chakra-ui/react";
import Layout from "../../components/layout";
import {institutionService} from "../../services";
import {useForm} from "react-hook-form";

export default function Institution() {
    const toast = useToast();
    const [institution, setInstitution] = React.useState({});

    const {handleSubmit, register, setValue, formState: {errors, isSubmitting}} = useForm();

    React.useEffect(() => {
        institutionService.getInstitution("1").then(response => {
            setInstitution(response);

            if (response.name) {
                setValue("name", response.name);
            }
            if (response.description) {
                setValue("description", response.description);
            }
            if (response.address) {
                setValue("address", response.address);
            }
            if (response.phone) {
                setValue("phone", response.phone);
            }
            if (response.email) {
                setValue("email", response.email);
            }
            if (response.web) {
                setValue("web", response.web);
            }
            ;
        }).catch(error => {
            toast({
                title: "Error",
                description: error.message,
                position: 'top-right',
                variant:'solid',
                status: "error",
                duration: 9000,
                isClosable: true,
            });
        });

    }, []);


    function onSubmit(values) {
        const newInstitution = {
            "id": 1,
            "name": values.name,
            "description": values.description,
            "address": values.address,
            "phone": values.phone,
            "email": values.email,
            "web": values.web
        }
        institutionService.updateInstitution(newInstitution)
            .then(response => {
                setInstitution(response);
                toast({
                    title: 'Institution updated',
                    position: 'top-right',
                    status: 'success',
                    variant:'solid',
                    duration: 9000,
                    isClosable: true,
                });
                setValue("name", response.name);
                setValue("description", response.description);
                setValue("address", response.address);
                setValue("phone", response.phone);
                setValue("email", response.email);
                setValue("web", response.web);

            }).catch(err => {
            toast({
                title: 'Error',
                description: `${err.message}`,
                position: 'top-right',
                variant:'solid',
                status: 'error',
                duration: 4500,
                isClosable: true,
            })
        })
    }

    function onError(errors) {
        for (let error in errors) {
            toast({
                title: 'Error',
                description: `${errors[error].message}`,
                position: 'top-right',
                variant: 'subtle',
                status: 'error',
                duration: 4500,
                isClosable: true,
            })
        }
    }

    return (<Center>
        <Box
            mt={[10, 0]}
            maxW="800px"
            w={'full'}>
            <chakra.form
                onSubmit={handleSubmit(onSubmit, onError)}
                shadow="base"
                rounded={[null, "md"]}
                overflow={{ sm: "hidden" }}
            >
                <Stack
                    px={4}
                    py={5}
                    p={[null, 6]}
                    overflow="hidden"
                    bg={useColorModeValue("white", "gray.700")}>

                    <Heading fontSize={{base: '2xl', sm: '3xl'}}>
                        Institution information
                    </Heading>
                    <Text
                        fontSize="sm"
                        pb="1rem"
                        color={useColorModeValue("gray.600", "gray.400")}
                    >
                        This information will be used to display your
                        institution on the website.
                    </Text>
                    <SimpleGrid columns={[1, null, 2]} spacing={6}>
                        <FormControl as={GridItem}
                                     isInvalid={errors.name}
                                     colSpan={8}>
                            <FormLabel htmlFor="name">Name</FormLabel>
                            <Input
                                type="text"
                                id="name"
                                {...register('name', {
                                    minLength: {
                                        value: 3, message: "Name must be at least 3 characters"
                                    }
                                })}
                            />
                        </FormControl>

                        <FormControl as={GridItem}
                                     isInvalid={errors.email}
                                     colSpan={[8, 8, 4]}>
                            <FormLabel htmlFor="email">Email</FormLabel>
                            <Input
                                type="email"
                                id="email"
                                {...register('email', {
                                    pattern: {
                                        value: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i,
                                        message: 'Invalid email address',
                                    }, minLength: {
                                        value: 3, message: 'Email must be at least 6 characters',
                                    }, maxLength: {
                                        value: 320, message: 'Email address is too long',
                                    },

                                })}
                            />
                        </FormControl>

                        <FormControl as={GridItem}
                                     isInvalid={errors.phone}
                                     colSpan={[8, 8, 4]}>
                            <FormLabel htmlFor="phone">Phone</FormLabel>
                            <Input
                                type="tel"
                                id="phone"
                                {...register('phone', {
                                    pattern: {
                                        value: /^[0-9]{10}$/i, message: 'Invalid phone number',
                                    }, minLength: {
                                        value: 10, message: 'Phone number must be 10 digits',
                                    }, maxLength: {
                                        value: 10, message: 'Phone number is too long',
                                    },
                                })}
                            />
                        </FormControl>

                        <FormControl
                            as={GridItem}
                            isInvalid={errors.web}
                            colSpan={[8, null, 4]}>
                            <FormLabel htmlFor="web">Website</FormLabel>
                            <Input
                                type="url"
                                id="web"
                                {...register('web', {
                                    pattern: {
                                        value: /^(?:http(s)?:\/\/)?[\w.-]+(?:\.[\w\.-]+)+[\w\-\._~:/?#[\]@!\$&'\(\)\*\+,;=.]+$/i,
                                        message: 'Invalid URL',
                                    }, minLength: {
                                        value: 3, message: 'URL must be at least 3 characters',
                                    }, maxLength: {
                                        value: 320, message: 'URL is too long',
                                    },
                                })}
                            />
                        </FormControl>

                        <FormControl
                            as={GridItem}
                            isInvalid={errors.address}
                            colSpan={[8, null, 6]}>
                            <FormLabel htmlFor="address">Address</FormLabel>
                            <Input
                                type="text"
                                id="address"
                                {...register('address', {
                                    minLength: {
                                        value: 3, message: 'Address must be at least 3 characters',
                                    }, maxLength: {
                                        value: 320, message: 'Address is too long',
                                    },
                                })}
                            />
                        </FormControl>

                        <FormControl as={GridItem}
                                     isInvalid={errors.city}
                                     colSpan={8}>
                            <FormLabel htmlFor="description">Description</FormLabel>
                            <Textarea
                                type="text"
                                rows={5}
                                id="description"
                                {...register('description', {
                                    minLength: {
                                        value: 3, message: 'Description must be at least 3 characters',
                                    }, maxLength: {
                                        value: 320, message: 'Description is too long',
                                    },
                                })}
                            />
                        </FormControl>
                    </SimpleGrid>
                </Stack>
                <Box
                    px={{base: 4, sm: 6}}
                    py={3}
                    bg={useColorModeValue("gray.50", "gray.900")}
                    textAlign="right"
                >
                    <Button
                        isLoading={isSubmitting}
                        type="submit"
                        colorScheme='blue'
                    >
                        Save
                    </Button>
                </Box>
            </chakra.form>
        </Box>
    </Center>);
}
Institution.layout = Layout;
