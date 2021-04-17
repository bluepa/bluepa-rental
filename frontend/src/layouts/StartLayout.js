import React, { Component, useState } from 'react';
import { Image,View, Text, StyleSheet,Button } from 'react-native';
import {homeLayout,fontStyle,colorSet,sizeStyle,imgSrc} from '../GlobalStyles';

const StartLayout = ({navigation}) =>{
    return(
        <View>
            <View style={homeLayout.header}>
                <Text style ={styles.title} >블루파렌탈</Text>
            </View>
            <View style={homeLayout.content}>
                <Image style ={sizeStyle.mainImg}
                        source={imgSrc.home}>
                </Image>
                <Text style={styles.subtitle}>우리 동네 렌탈 블루파렌탈</Text>
                <Text style={styles.description}>블루파렌탈은 동네 직거래 마켓이에요.{'\n'}내 동네를 설정하고 시작해보세요</Text>
            </View>
            <View style={homeLayout.footer}>
                <Button color={colorSet.theme}
                        title={'동네 설정하고 시작하기'}
                        onPress={() => navigation.navigate('EmailJoin')}></Button>
            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    title:{
        ...fontStyle.title,
        color:colorSet.theme,
        textAlign:'center',
        justifyContent:'center',
    },
    subtitle:{
        ...fontStyle.medium_bold,
        textAlign:'center',
        justifyContent:'center',
        color:colorSet.defaultBlack,
        padding:8,
        paddingTop:15,
    },
    description: {
        ...fontStyle.small,
        textAlign:'center',
        justifyContent:'center',
        color: colorSet.defaultBlack,
    },
})
export default StartLayout;