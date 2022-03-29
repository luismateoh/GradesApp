import {
    Flex,
    Box,
    FormControl,
    FormLabel,
    InputGroup,
    InputRightElement,
    Input,
    Stack,
    Button,
    Heading,
    useColorModeValue,
    FormErrorMessage,
    useToast,
} from '@chakra-ui/react';
import {useForm} from 'react-hook-form'
import {useEffect, useState} from 'react';
import {ViewIcon, ViewOffIcon} from '@chakra-ui/icons';
import Header from "../components/header";
import {useRouter} from "next/router";
import {userService} from '../services';

export default function Login() {
    const router = useRouter();
    const toast = useToast()

    const [showPassword, setShowPassword] = useState(false);
    const {handleSubmit, register, formState: {errors, isSubmitting},} = useForm()

    useEffect(() => {
        if (userService.userValue) {
            userService.userValue.role ? router.push('/' + userService
                .userValue
                .role
                .toString()
                .toLowerCase() + '') : router.push('/');

        }
    }, []);

    function onSubmit(values) {
        return new Promise((resolve) => {
            setTimeout(() => {
                const username = values.email.split('@')[0];
                userService.login(username, values.password)
                    .then(() => {
                        userService.userValue.role ? router.push('/' + userService
                            .userValue
                            .role
                            .toString()
                            .toLowerCase() + '') : router.push('/');
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
                resolve()
            }, 3000)
        })
    }

    return (<>
            <Header/>
            <Flex
                minH={'90vh'}
                align={'center'}
                justify={'center'}
                bg={useColorModeValue('gray.50', 'gray.800')}>
                <Stack spacing={8} mx={'auto'} maxW={'lg'} py={12} px={6}>
                    <Stack align={'center'}>
                        <Heading fontSize={'4xl'}>Sign in to your account</Heading>
                    </Stack>
                    <Box
                        rounded={'lg'}
                        bg={useColorModeValue('white', 'gray.700')}
                        boxShadow={'lg'}
                        p={8}>
                        <Stack spacing={4}>
                            <form onSubmit={handleSubmit(onSubmit)}>
                                <FormControl id="email" isInvalid={errors.email} pb={3}>
                                    <FormLabel htmlFor='email'>Email</FormLabel>
                                    <Input
                                        id="email"
                                        type="email"
                                        {...register('email', {
                                            required: 'Email is required', pattern: {
                                                value: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i,
                                                message: 'Invalid email address',
                                            }, minLength: {
                                                value: 3, message: 'Email must be at least 6 characters',
                                            }, maxLength: {
                                                value: 320, message: 'Email address is too long',
                                            },

                                        })}
                                    />
                                    <FormErrorMessage h={"10px"}>
                                        {errors.email && errors.email.message}
                                    </FormErrorMessage>
                                </FormControl>
                                <FormControl id="password" isInvalid={errors.password} pb={3}>
                                    <FormLabel htmlFor='password'>Password</FormLabel>
                                    <InputGroup>
                                        <Input
                                            id="password"
                                            type={showPassword ? 'text' : 'password'}
                                            {...register('password', {
                                                required: 'Password is required', minLength: {
                                                    value: 2, message: 'Password must be at least 8 characters',
                                                }, maxLength: {
                                                    value: 32, message: 'Password is too long',
                                                }
                                            })}
                                        />

                                        <InputRightElement h={'full'}>
                                            <Button
                                                variant={'ghost'}
                                                onClick={() => setShowPassword((showPassword) => !showPassword)}>
                                                {showPassword ? <ViewIcon/> : <ViewOffIcon/>}
                                            </Button>
                                        </InputRightElement>
                                    </InputGroup>
                                    <FormErrorMessage>
                                        {errors.password && errors.password.message}
                                    </FormErrorMessage>
                                </FormControl>
                                <Stack spacing={10}>
                                    <Button
                                        type="submit"
                                        bg={'blue.400'}
                                        mt={3}
                                        color={'white'}
                                        isLoading={isSubmitting}
                                        _hover={{
                                            bg: 'blue.500',
                                        }}>
                                        Sign in
                                    </Button>
                                </Stack>
                            </form>
                        </Stack>
                    </Box>
                </Stack>
            </Flex>
        </>

    );
}