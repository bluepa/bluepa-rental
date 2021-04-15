import {Fonts} from './assets/fonts/Fonts';
export const colorSet = {
    background : 'white',
    theme : '#ff8b3e',
    defaultBlack:'black',
};
export const colorStyle ={
    background:{
        backgroundColor: colorSet.background,
    },
    header: {
        backgroundColor: colorSet.background, shadowColor: 'transparent',
    },
};
export const fontStyle = {
    title:{
        fontFamily: Fonts.TmoneyRoundWindExtraBold,
        fontSize: 45,
    },
    small:{
        fontSize: 15,
    },
    small_bold:{
        fontSize: 15,
        fontWeight:'bold',
    },
    medium:{
        fontSize: 20,
        
    },
    medium_bold:{
        fontSize: 20,
        fontWeight:'bold',
    },
    large:{
        fontSize: 25,
    },
    large_bold:{
        fontSize: 25,
        fontWeight:'bold',
    },
};