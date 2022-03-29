import {
    Box,
    Button,
    Drawer,
    DrawerBody, DrawerCloseButton,
    DrawerContent, DrawerFooter, DrawerHeader,
    DrawerOverlay,
    FormLabel,
    Input,
    InputGroup, InputLeftAddon, InputRightAddon, Select,
    Stack, Textarea, useDisclosure
} from "@chakra-ui/react";
import {AddIcon} from "@chakra-ui/icons";

function DrawerExample() {
    const { isOpen, onOpen, onClose } = useDisclosure()
    const firstField = React.useRef()

    return (
        <>
            <Button leftIcon={<AddIcon />} colorScheme='teal' onClick={onOpen}>
                Create user
            </Button>

        </>
    )
}