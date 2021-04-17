import { Directions } from 'react-native-gesture-handler';
import {Fonts} from './assets/fonts/Fonts';
export const colorSet = {
    background : 'white',
    theme : '#ff8b3e',
    defaultBlack:'black',
    softGrey:'#d8d8dc',
};
export const imgSrc={
    home:require('./assets/start_img.jpg'),
};
export const sizeStyle={
    mainImg:{
        width: '75%',
        height:'75%',
    },
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

export const homeLayout = {
    container: {
        flex: 1,
        backgroundColor: colorSet.background,
        margin:'0 auto',
      },
      header: {
        width: '100%',
        height: '15%',
      },
      content: {
        justifyContent: 'center',
        alignItems: 'center',
        height: '65%',
      },
      footer: {
        alignItems: 'center',
        justifyContent: 'center',
          flexDirection:'column',
        height: '15%',
      },
};