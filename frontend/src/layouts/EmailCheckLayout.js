import React, { Component, useState } from 'react';
import { Image, View, Text, StyleSheet, Button } from 'react-native';
import { homeLayout, fontStyle, colorSet, sizeStyle, imgSrc, colorStyle } from '../GlobalStyles';

const EmailCheck = ({ navigation }) => {
    return (
        <View style={styles.container}>
            <View style={homeLayout.header}>
            </View>
            <View style={homeLayout.content}>
                <Image style={sizeStyle.mainImg}
                    source={imgSrc.home}>
                </Image>
                <Text style={styles.subtitle}>이메일을 보냈습니다!</Text>
                <Text style={styles.description}>Email(으)로{'\n'}보내드린 이메일의 버튼을 탭하시오</Text>
                <Button color={colorSet.theme}
                    title={'이메일 앱 열기'}
                    onPress={() => navigation.navigate('EmailJoin')}></Button>
            </View>
            <View style={homeLayout.footer}>
                <View style={styles.footer}>
                    <Text style={styles.basicFont}>이미 계정이 있습니까?</Text>
                    <View style={styles.Btn}>
                        <Text style={ {textAlign:'center', textDecorationLine: 'underline'}} onPress={() => navigation.navigate('TypePassword')} >비밀번호 로그인</Text></View>
                </View>
            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    container:{
        ...colorStyle.background,
    },
    title: {
        ...fontStyle.title,
        color: colorSet.theme,
        textAlign: 'center',
        justifyContent: 'center',
    },
    subtitle: {
        ...fontStyle.medium_bold,
        textAlign: 'center',
        justifyContent: 'center',
        color: colorSet.defaultBlack,
        padding: 8,
        paddingTop: 15,
    },
    description: {
        ...fontStyle.small,
        textAlign: 'center',
        justifyContent: 'center',
        color: colorSet.defaultBlack,
    },
})
export default EmailCheck;