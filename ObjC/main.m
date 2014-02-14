//
//  main.m
//  JavaToObjC
//
//  Created by Max Rogers on 2/10/14.
//  Copyright (c) 2014 Max Rogers. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Person.h"
#import "Male.h"
#import "Female.h"
int main(int argc, const char * argv[])
{

    @autoreleasepool {
        
        // insert code here...
        NSString *name = @"Barack Obama";
        NSDateComponents *bday = [[NSDateComponents alloc] init];
        [bday setYear:1961];
        [bday setMonth:8];
        [bday setDay:4];
        Male *obama = [[Male alloc] init:name :bday];
        Female *michelle = [[Female alloc] init:@"Michelle Obama" :[Person makeBday:01 : 17 : 1964]];
        [michelle setSpouse:obama];
        Female *malia = [[Female alloc] init:@"Malie Obama" :[Person makeBday:07 :04 :1998]];
        Female *natasha = [[Female alloc] init:@"Natasha Obama" :[Person makeBday:06 :01 :2001]];
        [obama addChild:malia];
        [obama addChild:natasha];
        NSLog([NSString stringWithFormat:@"%@%@%@%@" ,[obama toString], [michelle toString], [malia toString] ,[natasha toString]]);
    }
    return 0;
}


/*
In Java this would look more like 
public class Main{
    public static void main(String[] args){
        System.out.println("Hello World");
    }
 }
*/