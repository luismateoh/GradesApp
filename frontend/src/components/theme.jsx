import { extendTheme } from "@chakra-ui/react";

import "@fontsource/poppins/400.css";
import "@fontsource/poppins/600.css";
import "@fontsource/poppins/700.css";
import "@fontsource/poppins/800.css";

const config = {
  initialColorMode: "light",
  useSystemColorMode: false,
  fonts: {
    body: "Poppins, -apple-system",
    heading: "Poppins, -apple-system",
  },
};

export const theme = extendTheme({ config });
