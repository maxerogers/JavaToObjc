//
//  Person.m
//  JavaToObjC
//
//  Created by Max Rogers on 2/10/14.
//  Copyright (c) 2014 Max Rogers. All rights reserved.
//

#import "Person.h"

@implementation Person
-(id) init:(NSString *)name :(NSDateComponents *)bday
{
    self = [super init];
    if(self){
        self.name = name;
        self.birthday = bday;
    }
    return self;
}

-(BOOL) isMale{return false;}
-(BOOL) isFemale{return false;}
-(NSString *) gender{return @"NONE";}

-(int) calculateAge{
    NSDateComponents *components = [[NSCalendar currentCalendar] components:NSDayCalendarUnit | NSMonthCalendarUnit | NSYearCalendarUnit fromDate:[NSDate date]];
    NSInteger year = [components year];
    return (int) (year - self.birthday.year);
}

-(NSString *) toString{
    NSString *result = [NSString stringWithFormat:@"\n%@:\t{Age:\t%d", self.name, [self calculateAge] ];
    result = [NSString stringWithFormat:@"%@\n\t\t\tBDay:\t%ld/%ld/%ld", result, self.birthday.month, self.birthday.day, (long)self.birthday.year ];
    if(self.spouse != nil){
        result = [NSString stringWithFormat:@"%@\n\t\t\tSpouse:\t%@", result, self.spouse.name ];
    }
    if(self.father != nil)
        result = [NSString stringWithFormat:@"%@\n\t\t\tFather:\t%@", result, self.father.name ];
    if(self.mother != nil)
        result = [NSString stringWithFormat:@"%@\n\t\t\tMother:\t%@", result, self.mother.name ];
    if(self.children != nil)
    {
        result = [NSString stringWithFormat:@"%@\n\t\t\tChildren:\t", result];
        for(Person *p in self.children) {
            result = [NSString stringWithFormat:@"%@\n\t\t\t\t%@", result, p.name ];
        }
    }
    result = [NSString stringWithFormat:@"%@}", result ];
    return result;
}

-(BOOL) alreadyClaimedChild:(Person *)p{
    for(Person *c in self.children)
    {
        if([p.name isEqualTo:c.name])
            return true;
    }
    return false;
}
-(void) addParents:(Person *)dad :(Person *)mom{
    self.father = dad;
    self.mother = mom;
}
-(void) addChild:(Person *)p{
    if(self.children == nil)
        self.children = [NSMutableArray array];
    [self.children addObject:p];
    if(self.isMale){
        p.father = self;
    }else{
        p.mother = self;
    }
    if(self.spouse != nil && ![self.spouse alreadyClaimedChild:p]){
        if(self.isMale){
            p.mother = self.spouse;
        }else{
            p.father = self.spouse;
        }
        [self.spouse addChild:p];
    }
}

+(NSDateComponents *) makeBday: (int) month : (int) day : (int) year{
    NSDateComponents *bday = [[NSDateComponents alloc] init];
    [bday setYear:year];
    [bday setMonth:month];
    [bday setDay:day];
    return bday;
}

-(void) setSpouse:(Person *)p{
    _spouse = p;
    if(p.spouse == nil){
        [p setSpouse:self];
    }
}
@end
