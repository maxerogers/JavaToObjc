//
//  Person.h
//  JavaToObjC
//
//  Created by Max Rogers on 2/10/14.
//  Copyright (c) 2014 Max Rogers. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Gender.h"

@interface Person : NSObject<Gender>
@property NSString *name;
@property NSDateComponents *birthday;
@property Person *father;
@property Person *mother;
@property (nonatomic) Person *spouse;
@property NSMutableArray *children;
-(int)calculateAge;
-(id)init:(NSString *)name :(NSDateComponents *) bday;
-(NSString *) toString;
-(BOOL) alreadyClaimedChild: (Person *) p;
-(void) addParents:(Person *) dad : (Person *) mom;
-(void) addChild:(Person *) p;
-(void) setSpouse: (Person *) p;
+(NSDateComponents *) makeBday: (int) month :(int) date :(int) year;
@end
