import { DefaultSeo } from "next-seo";
import { ChakraProvider } from '@chakra-ui/react'
import SEO from "../../next-seo.config";
import {theme} from '../components/theme'
import {useRouter} from "next/router";
import {useEffect, useState} from "react";
import {userService} from "../services";
import App from "next/app";
import Layout from "../components/layout";

export default function MyApp({ Component, pageProps }) {
    const router = useRouter();
    const [authorized, setAuthorized] = useState(false);
    const Layout = Component.layout || (({children}) => <>{children}</>);
    useEffect(() => {

        // run auth check on initial load
        authCheck(router.asPath);

    }, []);

    function authCheck(url) {
        // redirect to login page if accessing a private page and not logged in
        const publicPaths = ['/', '/login','/404','/403','/500'];
        const path = url.split('?')[0];
        if (!userService.userValue && !publicPaths.includes(path)) {
            setAuthorized(false);
            router.push('/login');

        }else{
            setAuthorized(true);
        }


    }


    App.getInitialProps = async (ctx) => {
        const {Component} = ctx;
        const pageProps = Component.getInitialProps ? await Component.getInitialProps() : {};
        return {pageProps};
    };

  return (
      <>
          <DefaultSeo {...SEO} />

          <ChakraProvider resetCSS theme={theme}>

                  <Layout>
                      {authorized &&
                      <Component {...pageProps} />   }
                  </Layout>


          </ChakraProvider>
      </>

  )
}
